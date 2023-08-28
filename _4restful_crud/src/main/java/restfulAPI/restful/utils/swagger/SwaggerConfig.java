package restfulAPI.restful.utils.swagger;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi api(){
        return  GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/api/**")
                .build();

    }
}