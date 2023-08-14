package restfulAPI.restful.service;


import restfulAPI.restful.dto.response.UserResponse;
import restfulAPI.restful.entity.User;

public interface UserService {

    //Argument Resolver atau dari tokennya
    public UserResponse getUser(User user);
}
