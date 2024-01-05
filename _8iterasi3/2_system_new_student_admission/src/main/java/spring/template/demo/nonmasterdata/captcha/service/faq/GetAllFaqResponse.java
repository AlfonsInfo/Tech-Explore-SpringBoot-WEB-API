package spring.template.demo.nonmasterdata.captcha.service.faq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetAllFaqResponse {
    ArrayList<Faq> faqList;
}
