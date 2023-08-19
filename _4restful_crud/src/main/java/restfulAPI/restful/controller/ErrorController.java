package restfulAPI.restful.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import restfulAPI.restful.dto.ApiResponse;


//Exception di handle terpusat di RestController Advice
@RestControllerAdvice
public class ErrorController {


    //Menangkap Exception Constraint Violation ?
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse<String>> constraintViolationException(ConstraintViolationException exception)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ApiResponse.<String>builder().errors(exception.getMessage()).build());
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<ApiResponse<String>> apiException(ResponseStatusException exception)
    {
        return ResponseEntity.status(exception.getStatusCode())
                .body(ApiResponse.<String>builder().errors(exception.getMessage()).build());
    }
}
