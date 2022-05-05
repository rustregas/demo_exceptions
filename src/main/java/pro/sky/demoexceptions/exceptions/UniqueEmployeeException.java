package pro.sky.demoexceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UniqueEmployeeException extends RuntimeException{
    public UniqueEmployeeException(String message) {
        super(message);
    }
}
