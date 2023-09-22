package belajar.springboot._03hibernate.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Component;
import java.util.Locale;

@Component
public class FakerService {
    private final Faker faker;

    public FakerService() {
        this.faker = new Faker(new Locale("en-US"));
    }

    public Faker getFaker(){
        return this.faker;
    }

}
