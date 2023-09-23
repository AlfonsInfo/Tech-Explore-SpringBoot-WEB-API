package belajar.springboot._04Rest.restspring.controller;


import belajar.springboot._04Rest.restspring.dto.ApiResponse;
import belajar.springboot._04Rest.restspring.dto.request.CreateCollegeStudentRequest;
import belajar.springboot._04Rest.restspring.dto.response.CreateCollegeStudentResponse;
import belajar.springboot._04Rest.restspring.service.CollegeStudentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/college")
//@Validated
public class CollegeStudentController {

    @Autowired
    private CollegeStudentService collegeStudentService;
    //Binding Request Body, ModelAttribute, Request Params
    @PostMapping(path = "/student",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse<CreateCollegeStudentResponse> createCollegeData(
            HttpServletRequest httpServletRequest,
            /*@Valid*/ @RequestBody CreateCollegeStudentRequest request)
    {
        return collegeStudentService.createCollegeStudent(request);
    }
}
