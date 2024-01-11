package group.learn.webmvc.controller;

import group.learn.webmvc.data.CreatePersonRequest;
import group.learn.webmvc.data.EndPointConstant;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelAttributeController {


    @PostMapping(path = EndPointConstant.MODEL_ATTRIBUTE ,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String exampleModelAttribute(@ModelAttribute @Valid CreatePersonRequest request){
        return request.toString();
    }
}
