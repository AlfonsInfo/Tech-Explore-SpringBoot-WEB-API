package group.bootcamp.technicaltest.common.messagebroker;

import group.bootcamp.technicaltest.dto.request.ReqRegisDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerRabbitMq {
    @RabbitListener(queues = {"user-registration"})
    public void onUserRegistration(String event) {
        log.info("User Registration Event Received: {}", event);
    }
}
