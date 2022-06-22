package uz.uzcard.services.student.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import uz.uzcard.service.dbservice.dto.ApiResponse;
import uz.uzcard.service.dbservice.dto.StudentDto;
import uz.uzcard.service.dbservice.entity.Student;
import uz.uzcard.service.dbservice.repository.GroupRepository;
import uz.uzcard.service.dbservice.repository.StudentRepository;
import uz.uzcard.services.student.annotation.CheckAuth;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentController.class);
    private final StudentRepository studentRepository;
    private final GroupRepository groupRepository;

    @GetMapping("/get/{id}")
    public Student getStudent(@PathVariable Long id) {
        Optional<Student> studentById = studentRepository.findById(id);
        return studentById.orElse(null);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @CheckAuth
    @PostMapping("/add")
    public ApiResponse<Student> addStudent(@RequestBody StudentDto studentDto) {
        try {
            Student student = new Student();
            student.setFullName(studentDto.getFullName());
            student.setAge(studentDto.getAge());
            student.setGroup(groupRepository.findById(studentDto.getGroupId()).get());
            studentRepository.save(student);
            //		student.setGroup(groupClient.getGroup(studentDto.getGroupId()));
            return new ApiResponse<>("success", student, true);
        } catch (Exception e) {
            return new ApiResponse<>("error", false);
        }
    }

    @CheckAuth
    @DeleteMapping("/{id}")
    public ApiResponse<Student> deleteStudent(@PathVariable Long id) {
        try {
            studentRepository.deleteById(id);
            return new ApiResponse<>("success", true);
        } catch (Exception e) {
            return new ApiResponse<>("error", false);
        }
    }


}
