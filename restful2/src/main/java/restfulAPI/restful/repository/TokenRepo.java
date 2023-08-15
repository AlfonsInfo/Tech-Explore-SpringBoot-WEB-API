package restfulAPI.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restfulAPI.restful.entity.Token;

public interface TokenRepo extends JpaRepository<Token, Long> {
}
