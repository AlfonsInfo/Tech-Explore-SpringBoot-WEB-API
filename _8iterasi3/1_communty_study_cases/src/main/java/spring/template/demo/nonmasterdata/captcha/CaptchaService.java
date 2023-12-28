//package spring.template.demo.nonmasterdata.captcha;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.util.StringUtils;
//import org.springframework.web.client.RestOperations;
//import spring.template.demo.utils.exception.CustomValidationException;
//
//import java.net.URI;
//import java.util.regex.Pattern;
//
//@Service
//public class CaptchaService {
//    private static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");
//
//    private static final String REGISTER_ACTION = "register";
//
//
//    private final RestOperations restTemplate;
//    private  final CaptchaSettings captchaSettings;
//
//    @Autowired
//    public CaptchaService(RestOperations restTemplate, CaptchaSettings captchaSettings) {
//        this.restTemplate = restTemplate;
//        this.captchaSettings = captchaSettings;
//    }
//
//    public void processRecaptcha(String response, String action){
//        if(!responseSanityCheck(response)){
//            throw new CustomValidationException("Captcha Not Valid");
//        }
//
//        URI verifyUri = URI.create(String.format("https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s&remoteip=%s",
//                getReCaptchaSecret(), response, getClientIP()))
//        PostCaptchaResponse postCaptchaResponse = restTemplate.getForObject(verifyUri, PostCaptchaResponse.class);
//    }
//
//
//    private boolean responseSanityCheck(String response){
//        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
//    }
//}
