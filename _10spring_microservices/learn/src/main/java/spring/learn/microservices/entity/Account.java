package spring.learn.microservices.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Account extends BaseEntity{
    @Id
    private Long accountNumber;
    private Long customerId;
    private String email;
    private String mobileNumber;

}
