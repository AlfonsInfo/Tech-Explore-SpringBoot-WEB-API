package group.bootcamp.technicaltest.common;

import group.bootcamp.technicaltest.dto.BaseResponse;

import java.util.Objects;

public class RespMessageUtils {

    public static BaseResponse<String,String> successRespNoMessNoData(){
        BaseResponse<String, String> response = new BaseResponse<>();
        return response.successResponse(null,null);
    }

    public static BaseResponse<String,String> errorRespMess(String error){
        BaseResponse<String, String> response = new BaseResponse<>();
        String errMess = Objects.isNull(error) ? "Error" : error;
        return response.errorResponse(errMess);
    }
}
