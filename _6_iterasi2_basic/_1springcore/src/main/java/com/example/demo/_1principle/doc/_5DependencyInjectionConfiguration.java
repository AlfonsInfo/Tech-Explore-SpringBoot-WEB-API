package com.example.demo._1principle.doc;

import com.example.demo._1principle.doc.data.Bar;
import com.example.demo._1principle.doc.data.Foo;
import com.example.demo._1principle.doc.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

public class _5DependencyInjectionConfiguration {


    @Bean @Primary
    public Foo foo()
    {
        return new Foo();
    }


    @Bean
    public Foo fooSecond()
    {
        return new Foo();
    }


    @Bean
    public Bar bar()
    {
        return new Bar();
    }


    @Bean
    public FooBar fooBar(@Qualifier("fooSecond") Foo foo, Bar bar)
    {
        return  new FooBar(foo, bar);
    }
}
