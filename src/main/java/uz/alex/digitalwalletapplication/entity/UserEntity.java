package uz.alex.digitalwalletapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
public class UserEntity extends BaseEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToOne(mappedBy = "user")
    private WalletEntity wallet;
}
