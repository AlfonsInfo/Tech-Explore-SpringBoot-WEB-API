package com.example.demo;

import com.example.demo._1principle.doc._2BeanConfiguration;
import com.example.demo._1principle.doc._3DuplicateBeanConfiguration;
import com.example.demo._1principle.doc._4PrimaryBeanConfiguration;
import com.example.demo._1principle.doc.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class _3DuplicateTest {

    @Test
    void testGetBean()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(_3DuplicateBeanConfiguration.class);

        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            Foo foo1 = context.getBean(Foo.class);
        });
    }


    @Test
    void getBean()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(_3DuplicateBeanConfiguration.class);

        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1,foo2);
    }


    @Test
    void getBeanPrimary()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext(_4PrimaryBeanConfiguration.class);
        Foo foo0 = context.getBean(Foo.class);
        Foo foo1 = context.getBean("foo1", Foo.class);
        Foo foo2 = context.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1,foo2);
    }
}
