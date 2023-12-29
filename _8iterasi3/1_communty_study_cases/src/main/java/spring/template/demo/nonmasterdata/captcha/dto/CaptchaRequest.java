package spring.template.demo.nonmasterdata.captcha.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CaptchaRequest {
    private String secret;
    private String response;
}
