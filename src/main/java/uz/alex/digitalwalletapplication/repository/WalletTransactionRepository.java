package uz.alex.digitalwalletapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alex.digitalwalletapplication.entity.WalletTransactionEntity;

public interface WalletTransactionRepository extends JpaRepository<WalletTransactionEntity,Long> {
}
