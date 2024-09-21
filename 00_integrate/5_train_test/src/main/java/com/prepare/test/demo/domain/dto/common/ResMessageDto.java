package com.prepare.test.demo.domain.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ResMessageDto <T>{
    private Integer status;
    private String message;
    private T data;
}
