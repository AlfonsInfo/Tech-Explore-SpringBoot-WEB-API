package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.template.demo.nonmasterdata.faq.Faq;

@Repository
public interface FaqRepository extends JpaRepository<Faq, String> {

}
