package com.example.demo;

import com.example.demo._1principle.doc._5DependencyInjectionConfiguration;
import com.example.demo._1principle.doc.data.Bar;
import com.example.demo._1principle.doc.data.Foo;
import com.example.demo._1principle.doc.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class _4DependencyInjectionTest {



    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp()
    {
        applicationContext = new AnnotationConfigApplicationContext(_5DependencyInjectionConfiguration.class);
    }


    @Test
    void testDI()
    {
        Foo foo = applicationContext.getBean("fooSecond", Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);
        FooBar foobar = applicationContext.getBean(FooBar.class);
        Assertions.assertSame(foo, foobar.getFoo());
        Assertions.assertSame(bar, foobar.getBar());
    }
}
