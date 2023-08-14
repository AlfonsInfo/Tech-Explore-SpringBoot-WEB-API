package restfulAPI.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import restfulAPI.restful.entity.Address;

public interface AddressRepository extends JpaRepository<Address,String> {

}