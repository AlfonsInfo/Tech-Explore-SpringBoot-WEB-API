package spring.template.demo.entities.dto;

import lombok.Data;

@Data
public class ErrorSchema {
    private String errorCode;
    private ErrorMessageResponse errorMessageResponse;

    public void setSuccessResponse()
    {
        this.errorCode = "200";
        this.errorMessageResponse = new ErrorMessageResponse("Sukses", "Success");
    }

    public void setSuccessResponse(String errorCode, String indMessage, String engMessage){
        this.errorCode = errorCode ;
        this.errorMessageResponse = new ErrorMessageResponse(indMessage, engMessage);
    }
}
