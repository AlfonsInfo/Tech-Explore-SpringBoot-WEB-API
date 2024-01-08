package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.template.demo.nonmasterdata.auth.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,String> {

    List<User> findByEmailOrUsername(String email, String username);
}
