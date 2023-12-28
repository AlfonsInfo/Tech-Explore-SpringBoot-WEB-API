package spring.template.demo.entities.dto;

import lombok.Data;

@Data

public class ErrorSchema {
    private String errorCode;
    private String errorMessage;

    public void setSuccessResponse()
    {
        this.errorCode = "200";
        this.errorMessage = "Sukses";
    }
}
