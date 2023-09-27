package belajar.util.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;


//BASIC AUTH(Authorization) : Provide username & password
@Configuration
public class SpringJDBCConfig {
    //this will override user in application.properties
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource)
    {
        return new JdbcUserDetailsManager(dataSource);
    }


//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//
//        http.authorizeHttpRequests(configurer ->
//                configurer
//                        .requestMatchers("/actuator/**").hasRole("ADMIN")
//                        .requestMatchers("/api/**").permitAll()
//                        .requestMatchers("/college/student").hasRole("DEVELOPER")
//                        .requestMatchers("/**").permitAll()
//                )
//                .formLogin(Customizer.withDefaults())
////                .httpBasic(Customizer.withDefaults())
//                .csrf(AbstractHttpConfigurer::disable);
//        return http.build();
//    }

}
