package group.learn.webmvc.controller;


import group.learn.webmvc.data.EndPointConstant;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RequestParamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void wrongHttpMethodNotAllowed() throws Exception {
        mockMvc.perform(post(EndPointConstant.REQUEST_PARAM).queryParam("name", "alfons")).andExpectAll(
                status().isMethodNotAllowed());
    }

    @Test
    void successWithParam() throws Exception {
        mockMvc.perform(get(EndPointConstant.REQUEST_PARAM).queryParam("name", "alfons")).andExpectAll(
                status().isOk(),content().string(Matchers.containsString("Hello alfons")));
    }

    @Test
    void successWithoutParam() throws Exception {
        mockMvc.perform(get(EndPointConstant.REQUEST_PARAM)).andExpectAll(
                status().isOk(),content().string(Matchers.containsString("Hello Guest")));
    }
}
