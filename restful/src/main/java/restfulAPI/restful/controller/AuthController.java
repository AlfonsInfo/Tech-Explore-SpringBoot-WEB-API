package restfulAPI.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restfulAPI.restful.dto.request.LoginUserRequest;
import restfulAPI.restful.dto.request.RegisterUserRequest;
import restfulAPI.restful.dto.response.TokenResponse;
import restfulAPI.restful.dto.response.WebResponse;
import restfulAPI.restful.service.AuthService;

/** Controller terhubung dengan FrontEnd mlalui path dan terhubung ke service */
/** Bertanggung jawab menangani request HTTP */
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping(
            path = "/api/auth/register",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request)
    {
        authService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }


    @PostMapping(
            path = "api/auth/login",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    //WebResponse Bersifat Generic Karena Responsenya bisa macam-macam
    public WebResponse<TokenResponse> login(@RequestBody LoginUserRequest request)
    {
        TokenResponse token = authService.login(request);
        return  WebResponse.<TokenResponse>builder().data(token).build();
    }
}
