package restfulAPI.restful.service;

import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import restfulAPI.restful.entity.User;
import restfulAPI.restful.exception.ApiException;
import restfulAPI.restful.model.RegisterUserRequest;
import restfulAPI.restful.repository.UserRepository;
import restfulAPI.restful.security.BCrypt;

import java.util.Set;

/** Service (Lapisan berisi logika bisnis utama) berkerja dengan Repository (Data didatabase) dan Entity (Cetakan data) */
/** Usage dari Service berada di kelas Controller */

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator; // Karena beberapa hal tidak bisa divalidasi body nya

    @Override
    @Transactional
    public void register(RegisterUserRequest request) {
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(request);
        if(constraintViolations.size() != 0)
        {
            throw  new ConstraintViolationException(constraintViolations);
        }

        //Cek Apakah sudah ada datanya di Database
        if(userRepository.existsById(request.getUsername())){
//            throw new ApiException("Username already registered");
              throw  new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username Already Registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        //bcrypt -> tambahin manual / spring security
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getUsername());
        userRepository.save(user);
    }
}
