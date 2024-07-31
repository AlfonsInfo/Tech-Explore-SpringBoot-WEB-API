package group.bootcamp.technicaltest.configuration;


import group.bootcamp.technicaltest.common.RespMessageUtils;
import group.bootcamp.technicaltest.common.exception.CustomValidationException;
import group.bootcamp.technicaltest.dto.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerConfiguration {

    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<BaseResponse<String,String>> handleCustomValidationException(CustomValidationException exception){
        String mess = exception.getMessage();
        return ResponseEntity.badRequest().body(RespMessageUtils.errorRespMess(mess));
    }
}
