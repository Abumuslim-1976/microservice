package uz.uzcard.service.dbservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.uzcard.service.dbservice.entity.Student;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByPhoneNumber(String phoneNumber);

}
