package belajar.springboot._04Rest.restspring.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppDateTimeFormat {
    public static String timeStamp(){
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MM yyyy hh:mm:ss");
        return dateTimeFormatter.format(localDateTime);
    }
}
