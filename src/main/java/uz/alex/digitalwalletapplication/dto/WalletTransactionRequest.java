package uz.alex.digitalwalletapplication.dto;

import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
@Data
@ToString
public class WalletTransactionRequest {
    private Long userId;
    private BigDecimal amount;
    private String type; // "credit" or "debit"
}
