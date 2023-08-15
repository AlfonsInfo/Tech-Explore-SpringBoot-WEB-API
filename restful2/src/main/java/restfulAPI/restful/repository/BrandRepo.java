package restfulAPI.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restfulAPI.restful.entity.Brand;

public interface BrandRepo extends JpaRepository<Brand, Long> {
}
