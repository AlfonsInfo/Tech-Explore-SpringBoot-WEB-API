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
class ContentTypeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void  helloFormTest() throws Exception {
        mockMvc.perform(post(EndPointConstant.FORM_CONTENT_TYPE).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("name", "alfons"))
                .andExpectAll(
                        status().isOk(),
                        content().string(Matchers.containsString("Hello alfons")));
    }


    @Test
    void responseContentType() throws Exception {
        mockMvc.perform(post(EndPointConstant.RESPONSE_CONTENT_TYPE).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("name", "alfons"))
                .andExpectAll(
                        status().isOk(),
                        header().string(HttpHeaders.CONTENT_TYPE, Matchers.containsString(MediaType.TEXT_HTML_VALUE)),
                        content().string(Matchers.containsString("Hello alfons")));
    }
}
