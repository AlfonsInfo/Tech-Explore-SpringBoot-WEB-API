package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;


import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
public class UplaodControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    void uploadOk() throws Exception {
        mockMvc.perform(
                multipart(EndPointConstant.UPLOAD).file(
                        new MockMultipartFile(
                                "profile",
                                "profile.png",
                                "image/png",
                                getClass().getResourceAsStream("image/profile.png")
                        )
                ).contentType(MediaType.MULTIPART_FORM_DATA)).andExpectAll(
            status().isOk()
                        );
    }
}
