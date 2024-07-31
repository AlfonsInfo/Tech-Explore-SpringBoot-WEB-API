package group.bootcamp.technicaltest.specs;

import group.bootcamp.technicaltest.entity.SongEntity;
import org.springframework.data.jpa.domain.Specification;

public class SongSpecifications {

    public static Specification<SongEntity> songHasArtist() {
        return (root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("artist"));
    }
}
