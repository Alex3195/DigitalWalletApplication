package uz.alex.digitalwalletapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.alex.digitalwalletapplication.entity.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);
}
