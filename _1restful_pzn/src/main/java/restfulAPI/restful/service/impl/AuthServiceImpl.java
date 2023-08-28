package restfulAPI.restful.service.impl;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import restfulAPI.restful.dto.response.TokenResponse;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.dto.request.LoginUserRequest;
import restfulAPI.restful.dto.request.RegisterUserRequest;
import restfulAPI.restful.repository.UserRepository;
import restfulAPI.restful.security.BCrypt;
import restfulAPI.restful.service.AuthService;
import restfulAPI.restful.service.ValidationService;
import java.util.UUID;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class    AuthServiceImpl implements AuthService {

    private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ValidationService validationService;

    @Override
    @Transactional
    public void register(RegisterUserRequest request) {
        validationService.validate(request);

        //Cek Apakah sudah ada datanya di Database
        if(userRepository.existsById(request.getUsername())){
//            throw new ApiException("Username already regi  stered");
            throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username Already Registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        //bcrypt -> tambahin manual / spring security
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getUsername());
        userRepository.save(user);
    }


    @Override
    @Transactional
    public TokenResponse login( LoginUserRequest request) {
        validationService.validate(request);

        //Cek Apakah User ada atau tidak
        logger.info(request.getUsername());

        User user = userRepository.findById(request.getUsername())
                .orElseThrow(() ->
                {
                    logger.info("Test Apakah Error disini");
                    return new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or Password Wrong");
                }) ;

        logger.info("ngga sampai sini ngab?");

        //Cek Password



        logger.info("Request" + request.getPassword());
        logger.info("User" + user.getPassword());
        if(BCrypt.checkpw(request.getPassword(),user.getPassword())){
            user.setToken(UUID.randomUUID().toString());
            user.setTokenExpiredAt(next30Days());
            userRepository.save(user);

            return TokenResponse.builder()
                    .token(user.getToken())
                    .expiredAt(user.getTokenExpiredAt())
                    .build();
        }else{
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Username or Password Wrong");
        }
    }

    private Long next30Days()
    {
        return System.currentTimeMillis() + (1000*16 *24 *30);
    }


    @Transactional
    public void logout(User user)
    {
        user.setToken(null);
        user.setTokenExpiredAt(null);
        userRepository.save(user);

    }
}
