package restfulAPI.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import restfulAPI.restful.entity.Contact;
import restfulAPI.restful.entity.User;

import java.util.Optional;


@Repository
public interface ContactRepository extends JpaRepository<Contact,String>, JpaSpecificationExecutor {

    Optional<Contact> findFirstByUserAndId(User user, String id);


}
