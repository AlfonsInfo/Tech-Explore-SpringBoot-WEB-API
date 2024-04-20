package group.bootcamp.technicaltest.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {
    @Bean
    public Queue createUserRegistrationQueue() {
        return new Queue("user-registration");
    }
//    @Bean
//    public ConnectionFactory connectionRabbitMq(){
//        ConnectionFactory connection = new ConnectionFactory();
//        connection.setUri("amqp://guest:guest@localhost:5672/");
//        connection.setVirtualHost("/");
//
//    }
}
//connection via properties