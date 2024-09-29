package tech.learn.master.demo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Province extends BaseTimestampEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String provinceName;

    @OneToMany(mappedBy = "province", fetch = FetchType.LAZY)
    private Set<City> city;
}
