package group.bootcamp.technicaltest.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(req -> {
            req.requestMatchers("/**").permitAll();
            req.requestMatchers("/api/**").permitAll();
            req.requestMatchers("/swagger/**").permitAll();
        });

        return http.build();
    }
}
