package spring.template.demo.masterdata.error;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.template.demo.common.dto.BaseResponse;
import spring.template.demo.common.dto.ErrorSchema;
import spring.template.demo.common.exception.CustomValidationException;

import java.util.Locale;
import java.util.Objects;

@RestControllerAdvice
@Slf4j
public class ErrorController {

    @Autowired
    MessageSource messageSource;




    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<Object> validationExceptionHandling (CustomValidationException validationException, Locale locale)
    {
        log.error(validationException.getMessage(), validationException);
        ErrorSchema errorSchema = new ErrorSchema();
        String errorMessage = messageSource.getMessage("error.message",null,locale);
        if(Objects.equals(locale.getLanguage(), Locale.US.getLanguage())){
            errorMessage = validationException.getMessage();
        }

        //SET ERROR SCHEMA VALUES
        BaseResponse baseResponse = new BaseResponse();

        errorSchema.setErrorCode("400");
        errorSchema.setErrorMessage(errorMessage);
        baseResponse.setErrorSchema(errorSchema);

        return new ResponseEntity<>(baseResponse, HttpStatus.BAD_REQUEST);
    }
}
