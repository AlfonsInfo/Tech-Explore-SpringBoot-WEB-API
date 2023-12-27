package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.template.demo.masterdata.error.Error;

public interface ErrorRepository extends JpaRepository<Error, String> {

}
