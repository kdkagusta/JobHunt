package api.utilities;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ServiceAPIException extends RuntimeException {

    @Getter
    private HttpStatus status;
    private final String message;

    public ServiceAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ServiceAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
