package belajar.springboot._03hibernate.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="suc_student")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    //We need define fields, constructor,getter/setter, toString, but it can be handle by lombok

    @jakarta.persistence.Id
    @GeneratedValue(generator = "custom-id")
    @GenericGenerator(name="custom-id",strategy = "belajar.util.CustomIdGenerator")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // lombok
    private String Id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
}
