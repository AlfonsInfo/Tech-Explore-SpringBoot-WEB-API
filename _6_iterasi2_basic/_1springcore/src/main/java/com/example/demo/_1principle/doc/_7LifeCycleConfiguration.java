package com.example.demo._1principle.doc;


import com.example.demo._1principle.doc.data.Connection;
import com.example.demo._1principle.doc.data.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class _7LifeCycleConfiguration {

    @Bean
    public Connection connection(){
        return new Connection();
    }


    @Bean(initMethod = "Start", destroyMethod = "Stop")
    public Server server()
    {
        return new Server();
    }
}
