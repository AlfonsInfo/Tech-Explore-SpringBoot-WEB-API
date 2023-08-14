package restfulAPI.restful.service.impl;

import org.springframework.stereotype.Service;
import restfulAPI.restful.dto.response.UserResponse;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.service.UserService;

/** Service (Lapisan berisi logika bisnis utama) berkerja dengan Repository (Data didatabase) dan Entity (Cetakan data) */
/** Usage dari Service berada di kelas Controller */

@Service
public class UserServiceImpl implements UserService {


    @Override
    public UserResponse getUser(User user) {
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }
}
