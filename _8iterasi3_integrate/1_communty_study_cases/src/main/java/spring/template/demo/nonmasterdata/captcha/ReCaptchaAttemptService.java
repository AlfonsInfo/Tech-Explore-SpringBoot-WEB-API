package spring.template.demo.nonmasterdata.captcha;

import org.springframework.cglib.core.internal.LoadingCache;

public class ReCaptchaAttemptService {
    private int MAX_ATTEMPT = 4;
    private LoadingCache<String,String,Integer> attemptsCache;

}
