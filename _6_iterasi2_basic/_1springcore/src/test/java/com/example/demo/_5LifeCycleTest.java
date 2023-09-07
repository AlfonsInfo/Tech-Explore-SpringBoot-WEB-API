package com.example.demo;

import com.example.demo._1principle.doc._7LifeCycleConfiguration;
import com.example.demo._1principle.doc.data.Connection;
import com.example.demo._1principle.doc.data.Server;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class _5LifeCycleTest {

    ConfigurableApplicationContext applicationContext;

    //ConfigurableApplicationContext -> Punya method close
    @BeforeEach
    void setUp()
    {
        applicationContext = new AnnotationConfigApplicationContext(_7LifeCycleConfiguration.class);
        applicationContext.registerShutdownHook();
    }




    @Test
    void testConnection()
    {
        Connection connection = applicationContext.getBean(Connection.class);
    }

    @Test
    void testServer()
    {
        Server server = applicationContext.getBean(Server.class);
    }
}
