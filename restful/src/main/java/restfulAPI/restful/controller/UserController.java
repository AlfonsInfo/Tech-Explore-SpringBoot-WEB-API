package restfulAPI.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import restfulAPI.restful.dto.response.UserResponse;
import restfulAPI.restful.dto.response.WebResponse;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.service.UserService;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(User user)
    {
        UserResponse userResponse = userService.getUser(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }
}
