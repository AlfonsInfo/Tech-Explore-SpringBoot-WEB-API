package restfulAPI.restful.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import restfulAPI.restful.dto.request.UpdateUserRequest;
import restfulAPI.restful.dto.response.UserResponse;
import restfulAPI.restful.dto.response.WebResponse;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.service.UserService;

import javax.print.attribute.standard.Media;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    //Read
    @GetMapping(
            path = "/api/users/current",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(User user)
    {
        UserResponse userResponse = userService.getUser(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }


    //Get
    @PatchMapping(
            path = "/api/users/current",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    ) //user dari argument resolver ?
    public WebResponse<UserResponse> update(User user, @RequestBody UpdateUserRequest request)
    {
        UserResponse userResponse = userService.update(user,request);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }


}
