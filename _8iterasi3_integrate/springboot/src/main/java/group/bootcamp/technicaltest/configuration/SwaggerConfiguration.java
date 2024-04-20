package group.bootcamp.technicaltest.configuration;

import group.bootcamp.technicaltest.common.constants.Constants;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class SwaggerConfiguration {
    @Bean
    public OpenAPI openApi(){
        return new OpenAPI()
                .components(
                        new Components()
                                .addSecuritySchemes(Constants.SecurityConstant.PARAMS_API_KEY, apiKey())


                )
                .security(Collections.singletonList(new SecurityRequirement()));
    }


    private SecurityScheme apiKey(){
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.APIKEY);
        securityScheme.setIn(SecurityScheme.In.HEADER);
        securityScheme.name(Constants.SecurityConstant.PARAMS_API_KEY);
        securityScheme.description("Need API-KEY for All Request");
        return securityScheme;
    }
}
