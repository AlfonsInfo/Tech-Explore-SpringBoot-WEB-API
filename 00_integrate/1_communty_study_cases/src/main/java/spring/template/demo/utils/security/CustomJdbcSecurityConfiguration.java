package spring.template.demo.utils.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import spring.template.demo.entities.constant.Constant;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;


@EnableWebSecurity
@Configuration
@Profile("dev")
public class CustomJdbcSecurityConfiguration {


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {


        http
                .cors(httpSecurityCorsConfigurer -> httpSecurityCorsConfigurer.configurationSource(corsConfigurationSource()))
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        //* permit first (testing : disable authorization)
                        .requestMatchers(
                                Constant.EndPoint.FAQ_PREFIX,
                                Constant.EndPoint.FULL_REGISTER,
                                Constant.EndPoint.FULL_LOGIN,
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
        BCryptPasswordEncoder.BCryptVersion bcryptVersion = BCryptPasswordEncoder.BCryptVersion.$2Y;
        SecureRandom salt = new SecureRandom();
        int strengthFactorComplexity = 31;
        return new BCryptPasswordEncoder(bcryptVersion, strengthFactorComplexity,salt);
    }
}
