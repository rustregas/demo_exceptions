package pro.sky.demoexceptions.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class OverFlowEmployeeBookException extends RuntimeException{
    public OverFlowEmployeeBookException(String message) {
        super(message);
    }
}
