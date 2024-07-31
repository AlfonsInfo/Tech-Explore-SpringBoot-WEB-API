package group.bootcamp.technicaltest.configuration;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import group.bootcamp.technicaltest.common.ScreamingSnakeCaseStrategy;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestingConfiguration {
    @Bean
    public ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        mapper.setPropertyNamingStrategy(new ScreamingSnakeCaseStrategy());
        return mapper;
    }
    //* kofnigurasi khusus testing
}
