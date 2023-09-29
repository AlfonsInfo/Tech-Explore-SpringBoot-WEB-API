package belajar.springboot.auth.controller;

import belajar.springboot.auth.dto.AuthenticateResponse;
import belajar.springboot.auth.dto.AuthenticationRequest;
import belajar.springboot.auth.dto.RegisterRequest;
import belajar.springboot.auth.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/auth")
@RestController
@RequiredArgsConstructor
public class AuthenticationController {


    private final AuthenticationService service;
    @PostMapping("/register")
    public ResponseEntity<AuthenticateResponse> register(
            @RequestBody RegisterRequest request
    ){
        return ResponseEntity.ok(service.register(request));
    }


    @PostMapping("/login")
    public ResponseEntity<AuthenticateResponse> login(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
}
