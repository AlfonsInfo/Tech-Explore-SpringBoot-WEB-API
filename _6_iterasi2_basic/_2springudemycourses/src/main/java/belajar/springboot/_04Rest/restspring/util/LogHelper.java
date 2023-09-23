package belajar.springboot._04Rest.restspring.util;


import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LogHelper {


    public  String logTemplate( String fileName, String action){

        return AppDateTimeFormat.timeStamp() + "[" + fileName + "]" + " - " + "[" + action + "]" ;
    }

    public  String logTemplate(String fileName, String action, String data){
        return AppDateTimeFormat.timeStamp() + "[" + fileName + "]" + " - " + "[" + action + "]" + " data :" + "{"+ data + "}";
    }
}
