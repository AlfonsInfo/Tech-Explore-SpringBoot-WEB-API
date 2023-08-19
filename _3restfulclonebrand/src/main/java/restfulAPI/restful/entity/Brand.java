package restfulAPI.restful.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "brands")
public class Brand {
    @Id
    private Long id;
    private String desc;
}
