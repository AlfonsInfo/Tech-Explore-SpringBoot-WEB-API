package restfulAPI.restful.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "brands")
public class Brand {
    @Id
    private Long id;
    private String desc;
}
