package belajar.util.config;

import com.github.javafaker.Faker;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;


@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
