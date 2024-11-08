package uz.alex.digitalwalletapplication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import uz.alex.digitalwalletapplication.dto.WalletTransactionRequest;
import uz.alex.digitalwalletapplication.entity.UserEntity;
import uz.alex.digitalwalletapplication.entity.WalletEntity;
import uz.alex.digitalwalletapplication.repository.UserRepository;
import uz.alex.digitalwalletapplication.repository.WalletRepository;
import uz.alex.digitalwalletapplication.service.WalletService;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class WalletServiceTest {

    @Autowired
    private WalletService walletService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletRepository walletRepository;

    private UserEntity user;

    @BeforeEach
    void setUp() {
        user = new UserEntity();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");
        userRepository.save(user);

        WalletEntity wallet = new WalletEntity();
        wallet.setUser(user);
        walletRepository.save(wallet);
    }

    @Test
    void testPerformTransaction() {
        WalletTransactionRequest request = new WalletTransactionRequest();
        request.setUserId(user.getId());
        request.setAmount(BigDecimal.valueOf(50.00));
        request.setType("credit");

        walletService.performTransaction(request);

        WalletEntity updatedWallet = walletRepository.findByUserId(user.getId()).orElse(null);
        assertNotNull(updatedWallet);

        assertEquals(BigDecimal.valueOf(50.00).setScale(2, RoundingMode.HALF_UP), updatedWallet.getBalance());
    }
}



