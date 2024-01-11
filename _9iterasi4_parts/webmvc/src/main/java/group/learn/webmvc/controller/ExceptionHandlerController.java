package group.learn.webmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ExceptionHandlerController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException exception){
        return new ResponseEntity<>("Validation error" + exception.getMessage() , HttpStatus.BAD_REQUEST);
    }
}
