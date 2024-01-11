package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormController {

    @PostMapping(path = EndPointConstant.FORM, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createPerson(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "age") String age){
        return name + "-" + age;
    }

}
