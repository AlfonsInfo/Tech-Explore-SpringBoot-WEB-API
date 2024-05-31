//package group.bootcamp.technicaltest.configuration.firebase;
//
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.messaging.FirebaseMessaging;
//import lombok.SneakyThrows;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.properties.EnableConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.InputStream;
//
//@Configuration
//@EnableConfigurationProperties(FirebaseProperties.class)
//public class FirebaseConfiguration {
//
//
//    @Autowired
//    FirebaseProperties firebaseProperties;
//    @Bean
//    FirebaseMessaging firebaseMessaging(FirebaseApp firebaseApp){
//        return FirebaseMessaging.getInstance();
//    }
//
//    @Bean
//    FirebaseApp firebaseApp(GoogleCredentials credentials) {
//        FirebaseOptions options = FirebaseOptions.builder()
//                .setCredentials(credentials)
//                .build();
//
//        return FirebaseApp.initializeApp(options, "4_springboot_explore_feature");
//    }
//
//    @SneakyThrows
//    @Bean
//    GoogleCredentials googleCredentials() {
//        if (firebaseProperties.getServiceAccount() != null) {
//            try (InputStream is = firebaseProperties.getServiceAccount().getInputStream()) {
//                return GoogleCredentials.fromStream(is);
//            }
//        }
//        else {
//            // Use standard credentials chain. Useful when running inside GKE
//            return GoogleCredentials.getApplicationDefault();
//        }
//    }
//}
