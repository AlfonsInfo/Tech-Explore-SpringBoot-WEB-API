package spring.template.demo.nonmasterdata.captcha.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Data
public class CaptchaResponse {
    private boolean success;
    private String challengeTs;
    private String action;
    private String hostname;
    private double score;
    private ErrorCode[] errorCodes;


    @JsonIgnore
    public boolean hasClientError(){
        ErrorCode[] errors = getErrorCodes();
        if(errors == null){
            return false;
        }

        for(ErrorCode error : errors){
            if (Objects.requireNonNull(error) == ErrorCode.INVALID_RESPONSE) return true;
            if (error == ErrorCode.MISSING_RESPONSE) return true;
        }
            return false;
    }

    enum ErrorCode {
        MISSING_SECRET, INVALID_SECRET,
        MISSING_RESPONSE, INVALID_RESPONSE;

        private static final Map<String, ErrorCode> errorsMap = new HashMap<>(4);

        static {
            errorsMap.put("missing-input-secret", MISSING_SECRET);
            errorsMap.put("invalid-input-secret", INVALID_SECRET);
            errorsMap.put("missing-input-response", MISSING_RESPONSE);
            errorsMap.put("invalid-input-response", INVALID_RESPONSE);
        }

        @JsonCreator
        public static ErrorCode forValue(String value) {
            return errorsMap.get(value.toLowerCase());
        }

    }

    }
