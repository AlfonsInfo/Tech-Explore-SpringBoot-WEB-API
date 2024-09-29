package tech.learn.master.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Village extends BaseTimestampEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String villageName;

    @ManyToOne
    @JoinColumn(name = "subdistrict_id")
    private District district;
    private String villageType;
}
