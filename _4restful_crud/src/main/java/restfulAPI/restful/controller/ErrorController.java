package restfulAPI.restful.controller;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;
import restfulAPI.restful.dto.BaseResponse;
import restfulAPI.restful.dto.ErrorSchema;


//Exception di handle terpusat di RestController Advice
@RestControllerAdvice
public class ErrorController {


    //Menangkap Exception Constraint Violation ?
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<BaseResponse> constraintViolationException(ConstraintViolationException exception)
    {
        BaseResponse baseResponse = new BaseResponse();
        ErrorSchema errorSchema = new ErrorSchema();
        errorSchema.setErrorResponse("Gagal", exception.getMessage());
        baseResponse.setErrorSchema(errorSchema);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(baseResponse);
    }

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<BaseResponse> apiException(ResponseStatusException exception)
    {
        BaseResponse baseResponse = new BaseResponse();
        ErrorSchema errorSchema = new ErrorSchema();
        errorSchema.setErrorResponse("Gagal", exception.getMessage());
        baseResponse.setErrorSchema(errorSchema);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(baseResponse);
    }
}
