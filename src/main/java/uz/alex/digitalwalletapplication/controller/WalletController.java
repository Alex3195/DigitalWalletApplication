package uz.alex.digitalwalletapplication.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.alex.digitalwalletapplication.dto.WalletTransactionRequest;
import uz.alex.digitalwalletapplication.entity.WalletEntity;
import uz.alex.digitalwalletapplication.entity.WalletTransactionEntity;
import uz.alex.digitalwalletapplication.service.WalletService;

@RestController
@RequestMapping("/api/wallets")
public class WalletController {

    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<WalletTransactionEntity> performTransaction(@RequestBody WalletTransactionRequest request) {
        WalletTransactionEntity transaction = walletService.performTransaction(request);
        return ResponseEntity.ok(transaction);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<WalletEntity> getWallet(@PathVariable Long userId) {
        WalletEntity wallet = walletService.getWallet(userId);
        return ResponseEntity.ok(wallet);
    }
}
