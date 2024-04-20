package group.bootcamp.technicaltest.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


//@Import(TestingConfiguration.class)
@SpringBootTest
class CaseConfigurationTest {

    @Autowired
    ObjectMapper objectMapper;
    @Test
    void testCaseConfiguration(){
        Assertions.assertNotNull(objectMapper);
    }
}
