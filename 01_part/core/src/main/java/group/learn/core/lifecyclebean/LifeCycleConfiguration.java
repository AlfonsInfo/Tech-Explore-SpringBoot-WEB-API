package group.learn.core.lifecyclebean;

import group.learn.core.classtarget.lifecycle.Connection;
import group.learn.core.classtarget.lifecycle.Server;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {
    @Bean
    public Connection connection(){
        return new Connection();
    }

    @Bean(initMethod = "start", destroyMethod = "close")
    public Server server(){
        return new Server();
    }
}

class Main1{
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        //Connection connection = context.getBean(Connection.class);
        context.close();
    }
}
