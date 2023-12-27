package spring.template.demo.utils.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import spring.template.demo.entities.constant.Constant;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration{

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("user").password("password").roles("USER").build());
        return manager;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(httpSecurityCsrfConfigurer ->httpSecurityCsrfConfigurer.disable())
                .authorizeHttpRequests(authorize -> authorize
                        //* permit first (testing : disable authorization)
                        .requestMatchers(
                                Constant.EndPoint.FAQ_PREFIX,
                                Constant.EndPoint.FULL_REGISTER,
                                "/error"
                        ).permitAll()
                        //* need authenticated
                        .requestMatchers(
                                Constant.EndPoint.NEED_AUTHENTICATED
                        ).authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
