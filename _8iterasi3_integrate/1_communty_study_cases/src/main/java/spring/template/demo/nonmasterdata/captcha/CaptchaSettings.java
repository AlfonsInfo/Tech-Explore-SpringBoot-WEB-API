package spring.template.demo.nonmasterdata.captcha;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "google.recaptcha.key")
public class CaptchaSettings {
    private String site;
    private String secret;
    private double scoreThreshold;

}
