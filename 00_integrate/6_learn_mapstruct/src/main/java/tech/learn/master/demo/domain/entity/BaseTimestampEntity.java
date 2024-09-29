package tech.learn.master.demo.domain.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseTimestampEntity {
    private Long createdAt;
    private Long updatedAt;
}
