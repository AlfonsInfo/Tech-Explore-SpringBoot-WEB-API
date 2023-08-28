package restfulAPI.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import restfulAPI.restful.entity.Events;

@Repository
public interface LogRepository extends JpaRepository<Events, String> {
}
