package spring.template.demo.nonmasterdata.faq;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.template.demo.entities.constant.Constant;
import spring.template.demo.entities.dto.ApiResponse;

@RequestMapping(path = Constant.EndPoint.FAQ_PREFIX) // ** prefix endpoints with api */
@RestController
public class FaqController {

    private FaqService faqService;

    @GetMapping()
    public ApiResponse<GetAllFaqResponse> getAll()
    {
        return faqService.getAll();
    }
}
