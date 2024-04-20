package group.bootcamp.technicaltest.repository;

import group.bootcamp.technicaltest.entity.SongEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.UUID;

public interface SongRepository extends JpaRepository<SongEntity, UUID>, JpaSpecificationExecutor<SongEntity> {
    List<SongEntity> findAll(Specification<SongEntity> spec);


}
