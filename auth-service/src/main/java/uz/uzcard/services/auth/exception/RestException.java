package uz.uzcard.services.auth.exception;

import org.springframework.http.HttpStatus;
import uz.uzcard.services.auth.dto.ErrorData;

import java.util.List;

public class RestException extends RuntimeException{
    private String message;
    private HttpStatus status;
    private Object object;
    private List<ErrorData> errorData;

    public RestException(HttpStatus status, String message, Object object) {
        this.status = status;
        this.message = message;
        this.object = object;
    }

    public RestException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public RestException(HttpStatus status, List<ErrorData> errorData) {
        this.status = status;
        this.errorData = errorData;
    }

    public List<ErrorData> getErrorData() {
        return errorData;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Object getObject() {
        return object;
    }
}
