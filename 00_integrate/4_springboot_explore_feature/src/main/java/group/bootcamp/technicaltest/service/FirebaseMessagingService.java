package group.bootcamp.technicaltest.service;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.FirebaseMessagingException;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import group.bootcamp.technicaltest.dto.message.NotificationMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirebaseMessagingService {
    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public String sendNotificationByToken(NotificationMessage notificationMessage){
        Notification notification = new Notification(notificationMessage.getRecipientToken(), notificationMessage.getBody());

        Message message = Message
                .builder()
                .setToken(notificationMessage.getTitle())
                .setNotification(notification)
                .putAllData(notificationMessage.getData())
                .build();

        try{
            firebaseMessaging.send(message);
            return "Success Sending Notif";
        }catch(FirebaseMessagingException e){
            e.printStackTrace();
            return "Error Sending Notification";
        }
    }
}
