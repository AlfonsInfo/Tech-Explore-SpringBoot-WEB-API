package spring.template.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.template.demo.nonmasterdata.faq.Faq;

public interface FaqRepository extends JpaRepository<Faq, String> {

}
