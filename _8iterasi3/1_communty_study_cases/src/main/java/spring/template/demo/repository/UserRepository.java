package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.template.demo.auth.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
}
