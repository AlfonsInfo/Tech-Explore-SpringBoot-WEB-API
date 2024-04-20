package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FormControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void formTestOk() throws Exception {
        mockMvc.perform(post(EndPointConstant.FORM).param("name","alfons").param("age","20").contentType(MediaType.APPLICATION_FORM_URLENCODED)).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("alfons-20")));
    }
}
