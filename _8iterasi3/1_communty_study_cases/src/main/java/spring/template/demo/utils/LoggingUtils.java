package spring.template.demo.utils;

import lombok.experimental.Helper;
import org.springframework.stereotype.Component;

@Component
public class LoggingUtils {
    public  String logTemplate( String position, String action){
        return AppDateTimeFormat.timestamp() + "[" + position + "]" + " - " + "[" + action + "]".toUpperCase();
    }
}
