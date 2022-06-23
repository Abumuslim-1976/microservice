package uz.uzcard.service.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzcard.service.dbservice.entity.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
    Optional<Role> findByName(String name);
}
