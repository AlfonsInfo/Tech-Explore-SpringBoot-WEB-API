package group.learn.configproperties.messagesource;

import lombok.Setter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

@SpringBootApplication
public class MessageSourceExample {
    @Component
    public static class SampeSource implements MessageSourceAware{
        @Setter
        private MessageSource messageSource;

        public String helloYou(){
            return messageSource.getMessage("hello" , new Object[]{"Alfons"}, Locale.getDefault());
        }
    }


}
