package com.example.demo._1principle.doc;

import com.example.demo._1principle.doc.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Slf4j
@Configuration
public class _3DuplicateBeanConfiguration {



    @Primary
    @Bean
    public Foo foo1()
    {
        Foo foo = new Foo();
        log.info("Foo1 : Create new Foo");
        return foo;

    }

    @Bean
    public Foo foo2()
    {
        Foo foo = new Foo();
        log.info("Foo2 : Create new Foo");
        return foo;

    }
}
