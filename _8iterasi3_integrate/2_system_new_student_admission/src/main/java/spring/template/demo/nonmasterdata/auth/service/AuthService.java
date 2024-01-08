package spring.template.demo.nonmasterdata.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.template.demo.nonmasterdata.auth.dto.request.LoginRequest;
import spring.template.demo.nonmasterdata.auth.dto.request.RegisterRequest;
import spring.template.demo.nonmasterdata.auth.dto.response.LoginResponse;
import spring.template.demo.nonmasterdata.auth.dto.response.RegisterResponse;
import spring.template.demo.nonmasterdata.auth.entities.User;
import spring.template.demo.common.dto.ApiResponse;
import spring.template.demo.common.dto.BaseResponse;
import spring.template.demo.common.dto.ErrorSchema;
import spring.template.demo.repository.UserRepository;
import spring.template.demo.utils.CommonValidator;
import spring.template.demo.utils.LoggingUtils;
import spring.template.demo.common.exception.CustomValidationException;

import java.util.List;

@Service // * Spring framework stereotyp
@Slf4j //* By lombok
public class AuthService {

    private final LoggingUtils loggingUtils;
    private final UserRepository userRepository;
    private final CommonValidator commonValidator;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(LoggingUtils loggingUtils, UserRepository userRepository, CommonValidator commonValidator, PasswordEncoder passwordEncoder)
    {
        this.loggingUtils = loggingUtils;
        this.userRepository = userRepository;
        this.commonValidator = commonValidator;
        this.passwordEncoder = passwordEncoder;
    }



    @Transactional
    public BaseResponse register(RegisterRequest request) {
            //Define Variable
            String activity = "REGISTER SERVICE";
            RegisterResponse responseData = new RegisterResponse();
            ErrorSchema errorSchema =new ErrorSchema();

            //Logging
            log.info(loggingUtils.logTemplate(activity, "MAP REQUEST DATA TO OBJECT AND SAVINGS TO DB" ));

            //Validation
            commonValidator.validate(request);

            //decoding password
            String hashPassword = passwordEncoder.encode(request.getPassword());

            User user = User
                    .builder()
                    .username(request.getUsername())
                    .email(request.getEmail())
                    .password(hashPassword)
                    .build();
            userRepository.save(user);

            //Set error Schema
            errorSchema.setSuccessResponse();

            //return via template
            BaseResponse response = new BaseResponse();
            response.setErrorSchema(errorSchema);
            return response;
    }


    @Transactional
    public ApiResponse<LoginResponse> login(LoginRequest request){

        List<User> user =  userRepository.findByEmailOrUsername(request.getUsername(),request.getUsername());

        if(user.isEmpty())
            throw new CustomValidationException("Username dan Password Salah"); //change to throw exception

        if(!passwordEncoder.matches(request.getPassword(),user.get(0).getPassword()))
            throw new CustomValidationException("Username dan Password Salah"); //change to throw exception

        ErrorSchema errorSchema = new ErrorSchema();
        errorSchema.setSuccessResponse();

        LoginResponse loginResponse = new LoginResponse();

        // Prepare for response data
        ApiResponse<LoginResponse> response = new ApiResponse<>();
        response.setErrorSchema(errorSchema);
        response.setResponseData(loginResponse);

        return response;
    }
}
