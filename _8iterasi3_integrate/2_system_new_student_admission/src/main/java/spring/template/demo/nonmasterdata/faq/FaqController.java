package spring.template.demo.nonmasterdata.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.template.demo.common.constant.Constant;
import spring.template.demo.common.dto.ApiResponse;

@RequestMapping(Constant.EndPoint.FAQ) // ** prefix endpoints with api */
@RestController
public class FaqController {

    @Autowired
    private FaqService faqService;

    @GetMapping()
    public ApiResponse<GetAllFaqResponse> getAll()
    {
        return faqService.getAll();
    }
}
