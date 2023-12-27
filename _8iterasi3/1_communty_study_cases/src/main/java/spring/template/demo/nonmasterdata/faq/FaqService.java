package spring.template.demo.nonmasterdata.faq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import spring.template.demo.entities.dto.ApiResponse;
import spring.template.demo.entities.dto.ErrorSchema;
import spring.template.demo.repository.FaqRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class FaqService {

    @Autowired
    FaqRepository faqRepository;

    public ApiResponse<GetAllFaqResponse> getAll()
    {
        //query data
        ArrayList<Faq> faqList = new ArrayList();
        faqList.addAll( faqRepository.findAll());

        //mapping data to response
        GetAllFaqResponse getAllFaqResponse = GetAllFaqResponse
                .builder()
                .faqList(faqList)
                .build();

        //set error schema
        ErrorSchema errorSchema = new ErrorSchema();
        errorSchema.setSuccessResponse();

        //set response
        ApiResponse<GetAllFaqResponse> response = new ApiResponse<>();
        response.setResponseData(getAllFaqResponse);
        response.setErrorSchema(errorSchema);
        return response;
    }
}
