package spring.learn.microservices.dto;


import lombok.Data;

@Data
public class CustomerDto {
    private String name;
    private String email;
    private String mobileNumber;
}
