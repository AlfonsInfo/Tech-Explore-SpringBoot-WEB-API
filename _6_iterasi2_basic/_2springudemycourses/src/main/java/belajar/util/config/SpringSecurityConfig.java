package belajar.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


//BASIC AUTH(Authorization) : Provide username & password
@Configuration
public class SpringSecurityConfig {
    //this will override user in application.properties
    @Bean
    public InMemoryUserDetailsManager userDetailsManager()
    {
        UserDetails alfons = User.builder()
                .username("alfons")
                .password("{noop}password")
                .roles("DEVELOPER","ADMIN")
                .build();

        UserDetails ucup = User.builder()
                .username("ucup")
                .password("{noop}password")
                .roles("DEVELOPER")
                .build();

        return new InMemoryUserDetailsManager(ucup,
                alfons);
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/actuator/**").hasRole("ADMIN")
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/college/student").hasRole("DEVELOPER")
                        .requestMatchers("/**").permitAll()
                )
                .formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults())
                .csrf(AbstractHttpConfigurer::disable);
        return http.build();
    }

}
