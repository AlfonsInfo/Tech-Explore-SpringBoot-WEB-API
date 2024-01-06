package spring.template.demo.common.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import spring.template.demo.common.constant.Constant;
import spring.template.demo.common.filter.JWTTokenGeneratorFilter;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.List;


@EnableWebSecurity
@Configuration
@Profile("dev")
public class ProjectSecurityConfiguration {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        http
            .securityContext(context -> context .requireExplicitSave(false))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .cors(corsConfigurer ->corsConfigurer.configurationSource(corsConfigurationSource()))
            .csrf(csrfConfigurer -> csrfConfigurer.csrfTokenRequestHandler(requestHandler))
            .authorizeHttpRequests(authorize ->
                    authorize.requestMatchers(Constant.EndPoint.FAQ,Constant.EndPoint.FULL_REGISTER, Constant.EndPoint.FULL_LOGIN,"/error")
                            .permitAll()
                        .requestMatchers(Constant.EndPoint.NEED_AUTHENTICATED).authenticated()
            )
            .addFilterAfter(new JWTTokenGeneratorFilter(), BasicAuthenticationFilter.class)
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


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(List.of("http://localhost:4200"));
        corsConfiguration.setAllowedMethods(List.of("GET", "POST"));
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedHeaders(List.of("*"));
        corsConfiguration.setExposedHeaders(List.of("Authorization"));
        corsConfiguration.setMaxAge(3600L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
