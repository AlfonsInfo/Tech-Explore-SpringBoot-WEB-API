package restfulAPI.restful.service;

import restfulAPI.restful.dto.request.LoginUserRequest;
import restfulAPI.restful.dto.request.RegisterUserRequest;
import restfulAPI.restful.dto.response.TokenResponse;
import restfulAPI.restful.entity.User;

public interface AuthService {

    public void register(RegisterUserRequest request);
    public TokenResponse login(LoginUserRequest request);

    public void logout(User user);
}
