package restfulAPI.restful.service;

import restfulAPI.restful.dto.request.LoginUserRequest;
import restfulAPI.restful.dto.request.RegisterUserRequest;
import restfulAPI.restful.dto.response.TokenResponse;

public interface AuthService {

    public void register(RegisterUserRequest request);
    public TokenResponse login(LoginUserRequest request);
}
