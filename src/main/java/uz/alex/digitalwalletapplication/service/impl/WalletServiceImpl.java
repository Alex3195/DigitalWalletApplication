package uz.alex.digitalwalletapplication.service.impl;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import uz.alex.digitalwalletapplication.dto.WalletTransactionRequest;
import uz.alex.digitalwalletapplication.entity.UserEntity;
import uz.alex.digitalwalletapplication.entity.WalletEntity;
import uz.alex.digitalwalletapplication.entity.WalletTransactionEntity;
import uz.alex.digitalwalletapplication.repository.UserRepository;
import uz.alex.digitalwalletapplication.repository.WalletRepository;
import uz.alex.digitalwalletapplication.repository.WalletTransactionRepository;
import uz.alex.digitalwalletapplication.service.WalletService;

@Service
public class WalletServiceImpl implements WalletService {
    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final WalletTransactionRepository walletTransactionRepository;

    public WalletServiceImpl(UserRepository userRepository, WalletRepository walletRepository, WalletTransactionRepository walletTransactionRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.walletTransactionRepository = walletTransactionRepository;
    }

    @Override
    @Transactional
    public WalletTransactionEntity performTransaction(WalletTransactionRequest request) {
        UserEntity user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        WalletEntity wallet = walletRepository.findByUserId(user.getId()).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));

        // Transaction logic
        if (request.getType().equals("debit") && wallet.getBalance().compareTo(request.getAmount()) < 0) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        if (request.getType().equals("debit")) {
            wallet.setBalance(wallet.getBalance().subtract(request.getAmount()));
        } else if (request.getType().equals("credit")) {
            wallet.setBalance(wallet.getBalance().add(request.getAmount()));
        }

        WalletTransactionEntity transaction = new WalletTransactionEntity();
        transaction.setWallet(wallet);
        transaction.setAmount(request.getAmount());
        transaction.setType(request.getType());

        walletTransactionRepository.save(transaction);

        return transaction;

    }

    @Override
    public WalletEntity getWallet(Long userId) {
        WalletEntity wallet = walletRepository.findByUserId(userId).orElseThrow(() -> new IllegalArgumentException("Wallet not found"));
        if (wallet == null) {
            throw new IllegalArgumentException("Wallet not found for user ID: " + userId);
        }
        return wallet;
    }
}
