//package spring.template.demo.nonmasterdata.captcha;
//
//import com.fasterxml.jackson.annotation.JsonCreator;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Data;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//@Data
//public class PostCaptchaResponse {
//    private boolean success;
//    private String challengeTs;
//    private String action;
//    private String hostname;
//    private double score;
//    private ErrorCode[] errorCodes;
//
//
//    @JsonIgnore
//    public boolean hasClientError(){
//        ErrorCode[] errors = getErrorCodes();
//        if(errors == null){
//            return false;
//        }
//        for(ErrorCode error : errors){
//            switch (error) {
//                case InvalidResponse, MissingResponse -> {
//                    return true;
//                }
//            }
//        }
//            return false;
//    }
//
//    enum ErrorCode {
//        MissingSecret,     InvalidSecret,
//        MissingResponse,   InvalidResponse;
//
//        private static Map<String, ErrorCode> errorsMap = new HashMap<String, ErrorCode>(4);
//
//        static {
//            errorsMap.put("missing-input-secret",   MissingSecret);
//            errorsMap.put("invalid-input-secret",   InvalidSecret);
//            errorsMap.put("missing-input-response", MissingResponse);
//            errorsMap.put("invalid-input-response", InvalidResponse);
//        }
//
//        @JsonCreator
//        public static ErrorCode forValue(String value) {
//            return errorsMap.get(value.toLowerCase());
//        }
//
//}
