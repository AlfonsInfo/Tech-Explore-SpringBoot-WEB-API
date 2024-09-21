package tech.learn.master.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.learn.master.demo.domain.dto.schema.ResMessageDto;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(DuplicateException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResMessageDto<String> handleDuplicateException(DuplicateException exception) {
        return new ResMessageDto<>(400,  exception.getMessage(),null);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(org.springframework.http.HttpStatus.BAD_REQUEST)
    public ResMessageDto<List<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> String.format("Field '%s' %s", error.getField(), error.getDefaultMessage()))
                .toList();

        return new ResMessageDto<>(400, "Validation Error", errors);
    }
}
