package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.template.demo.masterdata.error.Error;

@Repository
public interface ErrorRepository extends JpaRepository<Error, String> {

}
