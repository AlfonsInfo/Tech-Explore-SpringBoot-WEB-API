package restfulAPI.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restfulAPI.restful.entity.User;

public interface UserRepo extends JpaRepository<User, Long> {
}
