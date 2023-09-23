package belajar.springboot._04Rest.restspring.entity.student;

import lombok.Builder;
import lombok.Data;

//The DTO

//@Entity must there a Id
@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
}
