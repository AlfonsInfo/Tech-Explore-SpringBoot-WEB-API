package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.template.demo.auth.entities.User;

public interface UserRepository extends JpaRepository<User,String> {
}
