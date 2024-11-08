package uz.alex.digitalwalletapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
public class WalletEntity extends BaseEntity {
    @OneToOne
    private UserEntity user;
    @Column(name = "balance")
    private BigDecimal balance = BigDecimal.ZERO;
}
