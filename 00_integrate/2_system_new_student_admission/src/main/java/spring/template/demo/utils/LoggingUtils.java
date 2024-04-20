package spring.template.demo.utils;

import lombok.experimental.Helper;
import org.springframework.stereotype.Component;

@Component
public class    LoggingUtils {
    public  String logTemplate( String position, String action){
        return AppDateTimeFormat.timestamp() + "[" + position + "]" + " - " + "[" + action + "]".toUpperCase();
    }

    public  String logFunction( String className, String serviceName, String position){
        return AppDateTimeFormat.timestamp() + "[ CLASS : " + className + "]" + " - " + "[ SERVICE " + serviceName + "]" + " - " + "[ POSITION " + position + "]" .toUpperCase();
    }
}
