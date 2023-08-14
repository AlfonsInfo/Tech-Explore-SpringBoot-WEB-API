package restfulAPI.restful.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restfulAPI.restful.dto.request.UpdateUserRequest;
import restfulAPI.restful.dto.response.UserResponse;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.repository.UserRepository;
import restfulAPI.restful.security.BCrypt;
import restfulAPI.restful.service.UserService;
import restfulAPI.restful.service.ValidationService;

import java.util.Objects;

/** Service (Lapisan berisi logika bisnis utama) berkerja dengan Repository (Data didatabase) dan Entity (Cetakan data) */
/** Usage dari Service berada di kelas Controller */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    ValidationService validationService;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserResponse getUser(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }

    @Override
    public UserResponse update(User user, UpdateUserRequest request) {
        validationService.validate(request);
        if(Objects.nonNull(request.getName()))
        {
            user.setName(request.getName());
        }

        if(Objects.nonNull(request.getPassword()))
        {
            user.setPassword(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt()));
        }
        userRepository.save(user);
        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                . build();


    }
}
