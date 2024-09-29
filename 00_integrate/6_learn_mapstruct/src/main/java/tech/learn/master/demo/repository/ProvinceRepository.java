package tech.learn.master.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.learn.master.demo.domain.entity.Province;

public interface ProvinceRepository extends JpaRepository<Province,Long>, JpaSpecificationExecutor<Province> {
    boolean existsByProvinceNameIgnoreCase(String provinceName);
    boolean existsByProvinceNameIgnoreCaseAndIdNot(String provinceName, Long provinceId);
}
