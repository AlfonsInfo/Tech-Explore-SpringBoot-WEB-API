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
class PathVariableControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void orderOk() throws Exception {
        mockMvc.perform(get(EndPointConstant.PATH_VARIABLE.replace("{orderId}","1").replace("{productId}","4"))).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("Order : 1 Product : 4"))
        );
        //Order : " + orderId + " Product : " + productId
    }
}
