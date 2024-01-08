package spring.template.demo.utils.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import spring.template.demo.entities.constant.Constant;

@EnableWebSecurity
@Configuration
@Profile("disabled")
public class BasicSecurityConfiguration {


    @Bean
    public UserDetailsService userDetailsService() {

        // manage user that save on memory
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        //Details Users // intended for testing &
        UserDetails admin = User.withUsername("admin").password("password").roles("user").build();
        UserDetails user = User.withUsername("user").password("password").roles("user").build();
        manager.createUser(admin);
        manager.createUser(user);
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

    @Bean //Deal with password
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
