package uz.uzcard.service.dbservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;

    private String fullName;

    private String phoneNumber;

    private Integer age;

    private Long groupId;

}
