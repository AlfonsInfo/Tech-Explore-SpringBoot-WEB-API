package spring.template.demo.nonmasterdata.captcha.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;
import spring.template.demo.nonmasterdata.captcha.CaptchaSettings;
import spring.template.demo.nonmasterdata.captcha.dto.CaptchaResponse;
import spring.template.demo.utils.exception.CustomValidationException;

import java.net.URI;
import java.util.Objects;
import java.util.regex.Pattern;

@Service
public class CaptchaService {
    private static final Pattern RESPONSE_PATTERN = Pattern.compile("[A-Za-z0-9_-]+");

    private final RestTemplate restTemplate;

    private final CaptchaSettings captchaSettings;

    public CaptchaService(RestTemplate restTemplate, CaptchaSettings captchaSettings) {
        this.restTemplate = restTemplate;
        this.captchaSettings = captchaSettings;
    }


    public void processRecaptcha(String response, String action){
        if(!responseSanityCheck(response)){
            throw new CustomValidationException("Captcha Not Valid");
        }
    }


    private boolean responseSanityCheck(String response){
        return StringUtils.hasLength(response) && RESPONSE_PATTERN.matcher(response).matches();
    }

    public CaptchaResponse verifyRecaptcha(String recaptchaToken){
        URI verifyUri = URI.create(String.format("https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s",
                    captchaSettings.getSecret(), captchaSettings.getSite()));

        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<Object> requestEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<CaptchaResponse> response = restTemplate.exchange(verifyUri, HttpMethod.POST,  requestEntity, CaptchaResponse.class);

        if(Objects.isNull(response.getBody()))
            throw new CustomValidationException("Body Null");

        if(Objects.equals(Boolean.FALSE, response.getBody().isSuccess()))
            throw new CustomValidationException("Token Not Valid");

        return response.getBody();
    }

}
