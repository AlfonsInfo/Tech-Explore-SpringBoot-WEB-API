package group.learn.webmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import group.learn.webmvc.data.EndPointConstant;
import group.learn.webmvc.data.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestBodyController {

    ObjectMapper objectMapper = new ObjectMapper();
    @PostMapping(value = EndPointConstant.REQUEST_BODY_1,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public String requestBodyPreference1(@RequestBody Person person){
        return "Hello " + person.getName();
    }

    @PostMapping(value = EndPointConstant.REQUEST_BODY_2,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String requestBodyPreference2(@RequestBody String data) throws JsonProcessingException {
        Person person = objectMapper.readValue(data, Person.class);
        return "Hello "+ person.getName();
    }
}
