package group.learn.webmvc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import group.learn.webmvc.data.EndPointConstant;
import group.learn.webmvc.data.Person;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.PostMapping;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RequestBodyControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void requestBody1() throws Exception {
        Person person = new Person();
        person.setName("alfons");
        person.setAge("20");
        ObjectMapper objectMapper = new ObjectMapper();

        mockMvc.perform(post(EndPointConstant.REQUEST_BODY_1).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(person))).andExpectAll(
                status().isOk(),
                content().string("Hello alfons"));
    }

}
