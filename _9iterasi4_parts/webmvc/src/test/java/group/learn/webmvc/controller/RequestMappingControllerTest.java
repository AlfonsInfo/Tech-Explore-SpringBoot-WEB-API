package group.learn.webmvc.controller;

//mock mvc builder, mock mvc requestbuilders, mock mvc result matchers

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
class RequestMappingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void requestMapping() throws Exception {
            mockMvc.perform(get(EndPointConstant.REQUEST_MAPPING)).andExpectAll(
                    status().isOk(),
                    content().string(Matchers.containsString("<h1>Hello from request-mapping</h1>")
                    ));
    }

}
