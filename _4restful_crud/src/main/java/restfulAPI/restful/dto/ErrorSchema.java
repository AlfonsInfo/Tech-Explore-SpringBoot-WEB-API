package restfulAPI.restful.dto;


import lombok.Data;
import restfulAPI.restful.entity.constant.Constant;


@Data
public class ErrorSchema {
    private String errorCode;

    private ErrorMessageResponse message;


    public void setSuccessResponse()
    {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(Constant.ErrorMessage.IdMessage.SUCCESS, Constant.ErrorMessage.EnMessage.SUCCESS);
        this.errorCode = Constant.ErrorHttpCode.SUCCESS;
        this.message = errorMessageResponse;
    }


    public void setErrorResponse(String badMessageId, String badMessageEn)
    {
        ErrorMessageResponse errorMessageResponse = new ErrorMessageResponse(badMessageId, badMessageEn);
        this.errorCode = Constant.ErrorHttpCode.BAD_REQUEST;
        this.message = errorMessageResponse;
    }
}
