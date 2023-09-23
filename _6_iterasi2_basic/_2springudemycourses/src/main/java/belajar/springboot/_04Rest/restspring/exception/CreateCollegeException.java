package belajar.springboot._04Rest.restspring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CreateCollegeException extends RuntimeException{
    public CreateCollegeException(String message) {
        super(message);
    }
}
