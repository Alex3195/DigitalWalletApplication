package uz.alex.digitalwalletapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alex.digitalwalletapplication.entity.WalletEntity;

import java.util.Optional;

public interface WalletRepository extends JpaRepository<WalletEntity, Long> {
    Optional<WalletEntity> findByUserId(long userId);
}
