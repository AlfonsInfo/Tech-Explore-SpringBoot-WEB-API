package spring.template.demo.utils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> customExceptionHandling(CustomException customException)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("error test");
    }
}
