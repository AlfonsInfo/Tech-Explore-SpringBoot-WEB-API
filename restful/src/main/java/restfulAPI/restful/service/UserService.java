package restfulAPI.restful.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfulAPI.restful.model.RegisterUserRequest;
import restfulAPI.restful.repository.UserRepository;

@Service
public interface UserService {

    public void register(RegisterUserRequest request);
}
