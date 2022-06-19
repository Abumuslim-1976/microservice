package uz.uzcard.services.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupDto {

    private Long id;

    private String name;

    private Integer groupNumber;

    private Long facultyId;

}
