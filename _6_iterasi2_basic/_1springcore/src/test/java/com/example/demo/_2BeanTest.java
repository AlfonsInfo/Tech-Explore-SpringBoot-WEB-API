package com.example.demo;

import com.example.demo._1principle.doc._2BeanConfiguration;
import com.example.demo._1principle.doc.data.Foo;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class _2BeanTest {

    @Test
    void testGetBean()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(_2BeanConfiguration.class);
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
    }
}
