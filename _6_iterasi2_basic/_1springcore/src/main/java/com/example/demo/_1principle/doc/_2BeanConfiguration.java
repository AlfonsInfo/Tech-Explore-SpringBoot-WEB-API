package com.example.demo._1principle.doc;


import com.example.demo._1principle.doc.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class _2BeanConfiguration {

    @Bean
    public Foo foo()
    {
        Foo foo = new Foo();
        log.info("Create new Foo");
        return foo;
    }
}
