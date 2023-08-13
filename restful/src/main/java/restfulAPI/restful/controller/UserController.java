package restfulAPI.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restfulAPI.restful.model.RegisterUserRequest;
import restfulAPI.restful.model.WebResponse;
import restfulAPI.restful.service.UserService;

import java.awt.*;

/** Controller terhubung dengan FrontEnd mlalui path dan terhubung ke service */
/** Bertanggung jawab menangani request HTTP */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(
            path = "/api/users",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request)
    {
        userService.register(request);
        return WebResponse.<String>builder().data("OK").build();
    }
}
