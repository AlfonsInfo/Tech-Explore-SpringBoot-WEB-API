package restfulAPI.restful.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import restfulAPI.restful.entity.constant.Constant;

@Data
public class BaseResponse {
    private ErrorSchema errorSchema;
}
