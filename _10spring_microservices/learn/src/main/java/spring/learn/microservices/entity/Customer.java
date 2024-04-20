package spring.learn.microservices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity //* Threat this class as entity representation or Pojo represetation of a table
@Data @AllArgsConstructor @NoArgsConstructor
public class Customer  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String name;
    private String email;
    private String mobileNumber;

}
