package task.astrapay.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    @JoinColumn(name = "product_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private CategoryEntity categoryEntity;
    private Double Rating;
    private Integer Stock;

}
