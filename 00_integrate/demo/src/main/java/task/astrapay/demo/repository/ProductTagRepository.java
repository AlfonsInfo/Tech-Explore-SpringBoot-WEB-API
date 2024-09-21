package task.astrapay.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.astrapay.demo.domain.entity.ProductEntity;
import task.astrapay.demo.domain.entity.ProductTagEntity;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductTagRepository extends JpaRepository<ProductTagEntity, Integer> {

    List<ProductTagEntity> findAllByProductEntity(ProductEntity productEntity);
}
