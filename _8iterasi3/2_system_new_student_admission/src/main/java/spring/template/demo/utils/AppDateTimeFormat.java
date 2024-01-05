package spring.template.demo.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class AppDateTimeFormat {
    public static String timestamp()
    {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy hh:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }
}
