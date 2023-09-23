package belajar.springboot._04Rest.restspring.dto;


import lombok.Data;

@Data
public class ErrorSchema {
    private String errorCode = "200";
    private ErrorMessageResponse message = new ErrorMessageResponse();

    public void setSuccessResponse(String indMessage, String engMessage){
        this.errorCode = "200";
        this.message.setEngMsg(engMessage);
        this.message.setIndoMsg(indMessage);
    }
}
