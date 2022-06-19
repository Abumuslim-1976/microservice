package uz.uzcard.service.dbservice.dto;

import lombok.Data;

@Data
public class RegisterDto {
    private String fullName;

    private String username;

    private String password;
}
