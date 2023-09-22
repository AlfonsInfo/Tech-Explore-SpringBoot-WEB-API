package belajar.springboot._04Rest.entity.student;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;


//@Entity must there a Id
@Data
@Builder
public class Student {
    private String firstName;
    private String lastName;
}
