package restfulAPI.restful.service;


import restfulAPI.restful.dto.request.UpdateUserRequest;
import restfulAPI.restful.dto.response.UserResponse;
import restfulAPI.restful.entity.User;

import java.util.Objects;

public interface UserService {

    //Argument Resolver atau dari tokennya
    public UserResponse getUser(User user);

    public UserResponse update(User user, UpdateUserRequest request);
}
