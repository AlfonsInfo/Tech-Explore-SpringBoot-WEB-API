package spring.template.demo.nonmasterdata.captcha;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PostCaptchaRequest {
    private String secret;
    private String response;
}
