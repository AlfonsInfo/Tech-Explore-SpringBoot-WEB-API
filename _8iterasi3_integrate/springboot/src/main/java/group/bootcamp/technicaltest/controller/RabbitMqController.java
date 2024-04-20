package group.bootcamp.technicaltest.controller;

import group.bootcamp.technicaltest.dto.request.ReqRegisDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/rabbit-mq")
public class RabbitMqController {

    private final RabbitTemplate rabbitTemplate;

    public RabbitMqController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @PostMapping
    public ResponseEntity<String> createUser(){
        rabbitTemplate.convertAndSend("","user-registration", "message");
        return ResponseEntity.ok("");
    }
}
