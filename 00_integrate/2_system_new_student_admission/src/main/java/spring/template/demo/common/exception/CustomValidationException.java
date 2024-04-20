package spring.template.demo.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomValidationException extends CustomException{
    public CustomValidationException(String message)
    {
        super(message);
    }

    public CustomValidationException(String property, String errorMessage)
    {

        super(property + " " + errorMessage);
    }


}
