package spring.template.demo.nonmasterdata.auth.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_authorities")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String userId;
    private String authoritiesId;

}
