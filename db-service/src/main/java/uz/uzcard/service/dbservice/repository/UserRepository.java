package uz.uzcard.service.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzcard.service.dbservice.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUsername(String username);

    Optional<User> findByUsername(String username);

}
