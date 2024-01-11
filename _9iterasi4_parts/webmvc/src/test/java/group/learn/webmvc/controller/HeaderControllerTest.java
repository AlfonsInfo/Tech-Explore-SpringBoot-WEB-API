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
 class HeaderControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Test
    void headerOk() throws Exception {
        mockMvc.perform(get(EndPointConstant.HEADER).header("X-TOKEN","ini token")).andExpectAll(
                status().isOk(),
                content().string(Matchers.containsString("OKEEEE"))
                );

    }

}
