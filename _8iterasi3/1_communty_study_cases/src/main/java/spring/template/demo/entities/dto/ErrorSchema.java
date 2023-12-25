package spring.template.demo.entities.dto;

import lombok.Data;

@Data
public class ErrorSchema {
    private String errorCode;
    private ErrorMessageResponse errorMessageResponse;

    public void setSuccessResponse(String indMessage, String engMessage){
        this.errorCode = "200";
        this.errorMessageResponse = new ErrorMessageResponse(indMessage, engMessage);
    }
}
