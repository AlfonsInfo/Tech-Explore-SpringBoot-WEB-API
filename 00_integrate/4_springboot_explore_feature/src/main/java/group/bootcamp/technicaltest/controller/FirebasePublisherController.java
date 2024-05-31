package group.bootcamp.technicaltest.controller;

import com.google.firebase.messaging.*;
import group.bootcamp.technicaltest.dto.request.ConditionMessageRepresentation;
import group.bootcamp.technicaltest.dto.request.MulticastMessageRepresentation;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FirebasePublisherController {

    private final FirebaseMessaging fcm;

    public FirebasePublisherController(FirebaseMessaging fcm) {
        this.fcm = fcm;
    }

    @SneakyThrows
    @PostMapping("/topics/{topic}")
    public ResponseEntity<String> postToTopic(@RequestBody String message, @PathVariable("topic") String topic) throws FirebaseMessagingException {

        Message msg = Message.builder()
                .setTopic(topic)
                .putData("body", message)
                .build();

        String id = fcm.send(msg);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(id);
    }

    @SneakyThrows
    @PostMapping("/condition")
    public ResponseEntity<String> postToCondition(@RequestBody ConditionMessageRepresentation message ) throws FirebaseMessagingException {

        Message msg = Message.builder()
                .setCondition(message.getCondition())
                .putData("body", message.getData())
                .build();

        String id = fcm.send(msg);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(id);
    }


    @PostMapping("/clients/{registrationToken}")
    public ResponseEntity<String> postToClient(@RequestBody String message, @PathVariable("registrationToken") String registrationToken) throws FirebaseMessagingException {

        Message msg = Message.builder()
                .setToken(registrationToken)
                .putData("body", message)
                .build();

        String id = fcm.send(msg);
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(id);
    }

    @PostMapping("/clients")
    public ResponseEntity<List<String>> postToClients(@RequestBody MulticastMessageRepresentation message) throws FirebaseMessagingException {

        MulticastMessage msg = MulticastMessage.builder()
                .addAllTokens(message.getRegistrationTokens())
                .putData("body", message.getData())
                .build();

        BatchResponse response = fcm.sendMulticast(msg);

        List<String> ids = response.getResponses()
                .stream()
                .map(r->r.getMessageId())
                .collect(Collectors.toList());

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(ids);
    }

    @SneakyThrows
    @PostMapping("/subscriptions/{topic}")
    public ResponseEntity<Void> createSubscription(@PathVariable("topic") String topic, @RequestBody List<String> registrationTokens) throws FirebaseMessagingException {
        fcm.subscribeToTopic(registrationTokens, topic);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @DeleteMapping("/subscriptions/{topic}/{registrationToken}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable String topic, @PathVariable String registrationToken) throws FirebaseMessagingException {
        fcm.subscribeToTopic(Arrays.asList(registrationToken), topic);
        return ResponseEntity.ok().build();
    }
}

