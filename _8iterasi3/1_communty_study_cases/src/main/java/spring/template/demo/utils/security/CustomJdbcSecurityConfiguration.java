package spring.template.demo.utils.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import spring.template.demo.entities.constant.Constant;


@EnableWebSecurity
@Configuration
@Profile("dev")
public class CustomJdbcSecurityConfiguration {

    /*   Doesn't needed
    **    @Bean
    **    public UserDetailsService userDetailsService(DataSource dataSource) {
    **        return  new CommunityUserDetails();
    **    }
    **/

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
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
