package group.bootcamp.technicaltest.controller;

import group.bootcamp.technicaltest.dto.BaseResponse;
import group.bootcamp.technicaltest.dto.request.ReqRegisDto;
import group.bootcamp.technicaltest.service.RegistrationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/register")
@RestController
public class RegistrationController {

    private final RegistrationService registrationService;
    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    ResponseEntity<BaseResponse<String,String>> registerAccount(@RequestBody @Valid ReqRegisDto request){
        BaseResponse<String,String> responseBody = registrationService.registerAccount(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseBody);
    }
}
