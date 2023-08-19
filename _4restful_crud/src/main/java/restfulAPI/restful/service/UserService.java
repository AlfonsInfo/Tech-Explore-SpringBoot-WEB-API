package restfulAPI.restful.service;


import jakarta.validation.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;
import restfulAPI.restful.dto.request.UserRegisRequest;
import restfulAPI.restful.dto.request.UserRegisRequest2;
import restfulAPI.restful.dto.response.UserRegisResponse;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.repository.UserRepository;
import restfulAPI.restful.utils.service.BCrypt;

import java.util.UUID;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    @Transactional
    public UserRegisResponse register(UserRegisRequest request)
    {
        //validationnya
        try {
//            if(ExistByUsername()){

//            }
            userRepository.save(
                    User.builder()
                            .uuid(UUID.randomUUID().toString())
                            .username(request.getUsername())
                            .password(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt()))
                            .email(request.getEmail())
                            .role(request.getRole())
                            .fotoProfil(request.getFotoProfil())
                            .build()
            );



            return UserRegisResponse.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .role(request.getRole())
                    .fotoProfil(request.getFotoProfil())
                    .build();
        }catch (Exception e){
            System.out.println("Errornya" +e.getMessage());
            return new UserRegisResponse();
        }
    }


    @Transactional
    public UserRegisResponse register2(UserRegisRequest2 request)
    {
        //validationnya

        if(userRepository.existsByUsername(request.getUsername())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username Already Registered");
        }

        try {
            userRepository.save(
                    User.builder()
                            .uuid(UUID.randomUUID().toString())
                            .username(request.getUsername())
                            .password(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt()))
                            .email(request.getEmail())
                            .role(request.getRole())
                            .fotoProfil(request.getFotoProfil().getBytes())
                            .build()
            );



            return UserRegisResponse.builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .role(request.getRole())
                    .fotoProfil(request.getFotoProfil().getBytes())
                    .build();
        }catch (Exception e){
            System.out.println("Errornya" +e.getMessage());
            return new UserRegisResponse();
        }
    }
}
