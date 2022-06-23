package uz.uzcard.service.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzcard.service.dbservice.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
