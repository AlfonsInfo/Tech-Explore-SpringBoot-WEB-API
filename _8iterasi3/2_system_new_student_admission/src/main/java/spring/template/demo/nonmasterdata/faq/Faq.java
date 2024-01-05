package spring.template.demo.nonmasterdata.faq;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "faqs")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Faq {
    @Id
    private String idFaq;
    private String question;
    private String answer;
}
