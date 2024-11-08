package uz.alex.digitalwalletapplication.service;

import uz.alex.digitalwalletapplication.dto.WalletTransactionRequest;
import uz.alex.digitalwalletapplication.entity.WalletEntity;
import uz.alex.digitalwalletapplication.entity.WalletTransactionEntity;

public interface WalletService {
    WalletTransactionEntity performTransaction(WalletTransactionRequest request);
    WalletEntity getWallet(Long id);
}
