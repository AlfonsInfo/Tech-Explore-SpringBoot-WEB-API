package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 class RequestMappingControllerIntegrationTest {
    @LocalServerPort
    private Integer port;
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void helloGuest(){
        String response = restTemplate.getForEntity("http://localhost:" + port + EndPointConstant.REQUEST_MAPPING, String.class)
                .getBody();
        Assertions.assertNotNull(response);
        Assertions.assertEquals("<h1>Hello from request-mapping</h1>",response.trim());
    }

}
