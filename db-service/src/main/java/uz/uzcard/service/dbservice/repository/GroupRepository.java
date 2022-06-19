package uz.uzcard.service.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzcard.service.dbservice.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
