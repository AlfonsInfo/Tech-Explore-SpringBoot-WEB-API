package group.bootcamp.technicaltest.controller;

import group.bootcamp.technicaltest.common.RespMessageUtils;
import group.bootcamp.technicaltest.dto.BaseResponse;
import group.bootcamp.technicaltest.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("auth/send-email")
@RestController
public class EmailController {
    EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/simple-email")
    ResponseEntity<BaseResponse<String,String>> simpleEmail(){
        emailService.sendSimpleMessage("alvonsus.setiawan@gmail.com", "Simple Email", "Message");
        BaseResponse<String,String> responseBody = RespMessageUtils.successRespNoMessNoData();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }

    @PostMapping("/email-templating")
    ResponseEntity<BaseResponse<String,String>> emailTemplating(){
        emailService.sendSimpleMessage("alvonsus.setiawan@gmail.com", "Simple Email", "Message");
        BaseResponse<String,String> responseBody = RespMessageUtils.successRespNoMessNoData();
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
}
