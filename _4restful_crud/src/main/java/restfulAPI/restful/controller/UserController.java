package restfulAPI.restful.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import restfulAPI.restful.dto.ApiResponse;
import restfulAPI.restful.dto.request.UserRegisRequest;
import restfulAPI.restful.dto.request.UserRegisRequest2;
import restfulAPI.restful.dto.response.UserRegisResponse;
import restfulAPI.restful.service.UserService;
import restfulAPI.restful.service.ValidationService;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ValidationService validationService;

    //Menggunakan Request Param dan Request Part
    @PostMapping(
            path = "/auth/register",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserRegisResponse> register(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            @RequestParam("role") String role,
            @RequestPart("fotoProfil") MultipartFile file
    ) {
        UserRegisRequest userRegisRequest = new UserRegisRequest();
            try {

                userRegisRequest.setUsername(username);
                userRegisRequest.setPassword(password);
                userRegisRequest.setEmail(email);
                userRegisRequest.setRole(role);
                userRegisRequest.setFotoProfil(file.getBytes());
                logger.debug("sampai sini lohh");
            } catch (Exception e) {
                // Tangani kesalahan
                logger.debug("Woy salah {}", e.getMessage());
            }
        UserRegisResponse userRegisResponse = userService.register(userRegisRequest);
        return new ResponseEntity<>(userRegisResponse, HttpStatus.OK);
    }

    //@RequestBody Tidak bisa handle file

    //Menggunakan Modal Attribute
    @PostMapping(
            path = "/auth/register2",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<UserRegisResponse> register2(
            @ModelAttribute UserRegisRequest2 request
    )
    {
        validationService.validate(request);
        System.out.println("Requestnya ini" + request);

        UserRegisResponse response = userService.register2(request);


        return  new  ApiResponse<>(
                "200",
                "Sukses Register",
                //new UserRegisResponse()
                response,
                null
        );
    }



}
