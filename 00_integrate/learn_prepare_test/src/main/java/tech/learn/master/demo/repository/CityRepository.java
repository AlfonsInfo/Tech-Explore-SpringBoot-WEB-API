package tech.learn.master.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import tech.learn.master.demo.domain.entity.City;
import tech.learn.master.demo.domain.entity.Province;

public interface CityRepository extends JpaRepository<City,Long>, JpaSpecificationExecutor<City> {
    boolean existsByCityNameIgnoreCase(String provinceName);
    boolean existsByCityNameIgnoreCaseAndIdNot(String provinceName, Long provinceId);
    Page<City> findAllByProvinceId(Long provinceId, Pageable pageable);
}
