package task.astrapay.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import task.astrapay.demo.domain.entity.CategoryEntity;
import task.astrapay.demo.domain.entity.ProductEntity;


@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {
}
