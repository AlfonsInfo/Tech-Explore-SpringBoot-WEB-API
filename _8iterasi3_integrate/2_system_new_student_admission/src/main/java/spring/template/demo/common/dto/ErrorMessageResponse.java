package spring.template.demo.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageResponse {
    private String indoMsg;
    private String engMsg;
}
