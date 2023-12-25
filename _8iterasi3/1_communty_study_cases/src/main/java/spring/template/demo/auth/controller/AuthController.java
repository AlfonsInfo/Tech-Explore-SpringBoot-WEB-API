package spring.template.demo.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.template.demo.auth.dto.request.RegisterRequest;
import spring.template.demo.auth.dto.response.RegisterResponse;
import spring.template.demo.auth.service.AuthService;
import spring.template.demo.entities.dto.ApiResponse;
import spring.template.demo.entities.dto.BaseResponse;

@RequestMapping(path = "/api/user") // ** prefix endpoints with api */
@RestController
public class AuthController{

    private final AuthService authService;
    @Autowired
    public AuthController (AuthService authService){
        this.authService = authService;
    }


    @PostMapping(value = "/register",
    consumes = {"application/json"})
    public BaseResponse register(@RequestBody RegisterRequest request)
    {
        // Security Header Checker
        return authService.register(request);
    }

}
