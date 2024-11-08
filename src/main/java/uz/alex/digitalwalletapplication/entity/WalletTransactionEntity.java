package uz.alex.digitalwalletapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "wallet_transactions")
@Setter
@Getter
public class WalletTransactionEntity extends BaseEntity {
    @ManyToOne
    private WalletEntity wallet;

    private BigDecimal amount;
    private String type; // "credit" or "debit"
    private LocalDateTime timestamp = LocalDateTime.now();
}
