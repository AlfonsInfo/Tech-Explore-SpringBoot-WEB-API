package restfulAPI.restful.utils.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.UserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Properties;

import static org.springframework.security.config.Customizer.withDefaults;


// Configure Form Login Here

@EnableWebSecurity
public class SecurityConfiguration {
    private static final String ADMIN = "ADMIN";
    private static final String PASSWORD = "PASSWORD";





        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests((authz) -> authz
                            .anyRequest().authenticated()
                    )
                    .httpBasic(withDefaults());
            return http.build();
        }


//        @Bean
//    public UserDetailsManagerConfigurer.UserDetailsBuilder setPassword(AuthenticationManagerBuilder auth) throws Exception{
//        return auth.inMemoryAuthentication()
//                .withUser(ADMIN)
//                .password(PASSWORD)
//                .roles(ADMIN);
//    }
}
