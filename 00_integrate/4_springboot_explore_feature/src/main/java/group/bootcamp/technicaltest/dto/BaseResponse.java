package group.bootcamp.technicaltest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse<T,S> {
    private String reqId;
    private String status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private S data;

    public BaseResponse<T,S> successResponse(T paramsMessage, S paramsData){
        String tempReqId = UUID.randomUUID().toString();
        String tempStatus =  "T";
        T tempMess =  getMessageResp(paramsMessage);

        return BaseResponse.<T, S>builder()
                .reqId(tempReqId)
                .status(tempStatus)
                .message(tempMess)
                .data(paramsData)
                .build();
    }

    public BaseResponse<T,String> errorResponse(T paramsMessage){
        String tempReqId = UUID.randomUUID().toString();
        String tempStatus =  "F";
        T tempMess =  getMessageResp(paramsMessage);

        return BaseResponse.<T, String>builder()
                .reqId(tempReqId)
                .status(tempStatus)
                .message(tempMess)
                .data(null)
                .build();
    }


    @SuppressWarnings("unchecked")
    private T getMessageResp(T paramsMessage) {
        T tempMessage;
        if(Objects.nonNull(paramsMessage)){
            tempMessage = paramsMessage;
        }else{
            tempMessage =  (T) "success";
        }
        return tempMessage;
    }


}
