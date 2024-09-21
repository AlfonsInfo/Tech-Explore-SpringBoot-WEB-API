package task.astrapay.demo.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "product_tag")
public class ProductTagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JoinColumn(name = "product_id")
    @ManyToOne
    private ProductEntity productEntity;
    @JoinColumn(name = "tag_id")
    @ManyToOne
    private TagEntity tagEntity;
}
