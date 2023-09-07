package com.example.demo;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class _1ApplicationContextTest {


    @Test
    void testApplicationContext()
    {
        ApplicationContext context = new AnnotationConfigApplicationContext();

        Assertions.assertNotNull(context);

    }
}
