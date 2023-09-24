package belajar.springboot._04Rest.restspring.util.logging;


import belajar.springboot._04Rest.restspring.entity.constant.Constant;
import belajar.springboot._04Rest.restspring.util.AppDateTimeFormat;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Component
public class LogHelper {


    public  String logTemplate( String fileName, String action){

        return AppDateTimeFormat.timeStamp() + "[" + fileName + "]" + " - " + "[" + action + "]" ;
    }

    public  String logTemplate(String fileName, String action, String data){
        return AppDateTimeFormat.timeStamp() + "[" + fileName + "]" + " - " + "[" + action + "]" + " data :" + "{"+ data + "}";
    }

    public  String logTemplateStartService( String fileName, String action){

        return AppDateTimeFormat.timeStamp() + "[" + fileName + "]" + " - "+ "[" +  Constant.ActionLogFlag.START_SERVICE  + action + "]" ;
    }

    public  String logTemplateEndService( String fileName, String action, Boolean successStatus){
        if(successStatus){
            return AppDateTimeFormat.timeStamp() + "[" + fileName + "]" + " - "+ "[SUCCESS]" + " - "+ "[" +  Constant.ActionLogFlag.END_SERVICE  + action + "]" ;
        }
        return AppDateTimeFormat.timeStamp() + "[" + fileName + "]" + " - "+ "[FAILED]" + " - "+ "[" +  Constant.ActionLogFlag.END_SERVICE  + action + "]" ;

    }

}
