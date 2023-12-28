package spring.template.demo.nonmasterdata.captcha;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "google.recaptcha.key")
public class CaptchaSettings {
    private String site;
    private String secret;
    private double scoreThreshold;

}
