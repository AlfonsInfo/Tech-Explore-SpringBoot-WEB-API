package restfulAPI.restful.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import restfulAPI.restful.dto.request.LoginUserRequest;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.repository.UserRepository;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest
@AutoConfigureMockMvc

class AuthControllerTest {



    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapper objectMapper;

//    @BeforeEach
//    void setUp()
//    {
//        userRepository.deleteAll();
//    }


    @Test
    void loginSuccess() throws Exception{
        LoginUserRequest request = new LoginUserRequest();
        request.setUsername("test");
        request.setPassword("rahasia");

        mockMvc.perform(
                post("/api/auth/login")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
        ).andExpect(
                status().isOk()
        );
    }

    @Test
    void testFindUserByUsername() {
        Optional<User> optionalUser = userRepository.findByUsername("test");

        assertTrue(optionalUser.isPresent(), "User with username 'alfons' should exist");

        User user = optionalUser.get();
        assertEquals("alfons", user.getUsername());
    }

}

