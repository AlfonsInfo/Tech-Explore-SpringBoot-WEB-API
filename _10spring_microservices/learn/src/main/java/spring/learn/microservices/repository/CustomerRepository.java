package spring.learn.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.learn.microservices.entity.Customer;

@Repository // creating bean implementation
public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
