package uz.uzcard.service.dbservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private T data;
    private boolean isSuccess;

    public ApiResponse(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }
}
