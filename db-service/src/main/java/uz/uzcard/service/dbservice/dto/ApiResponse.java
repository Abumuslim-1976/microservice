package uz.uzcard.service.dbservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse<T> {
    private String message;
    private T data;
    private List<ErrorData> errors;
    private boolean isSuccess;

    public ApiResponse(String message, boolean isSuccess) {
        this.message = message;
        this.isSuccess = isSuccess;
    }

    public ApiResponse(String message, T data, boolean isSuccess) {
        this.message = message;
        this.data = data;
        this.isSuccess = isSuccess;
    }
}
