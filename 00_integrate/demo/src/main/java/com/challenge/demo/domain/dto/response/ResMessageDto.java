package com.challenge.demo.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class ResMessageDto<T> {
    public String statusCode;
    public String message;
    public T data;
}
