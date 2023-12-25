package spring.template.demo.auth.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spring.template.demo.auth.dto.request.RegisterRequest;
import spring.template.demo.auth.dto.response.RegisterResponse;
import spring.template.demo.auth.entities.User;
import spring.template.demo.entities.dto.ApiResponse;
import spring.template.demo.entities.dto.BaseResponse;
import spring.template.demo.entities.dto.ErrorSchema;
import spring.template.demo.repository.UserRepository;
import spring.template.demo.utils.CommonValidator;
import spring.template.demo.utils.LoggingUtils;

@Service // * Spring framework stereotyp
@Slf4j //* By lombok
public class AuthService {

    private final LoggingUtils loggingUtils;
    private final UserRepository userRepository;
    private final CommonValidator commonValidator;

    @Autowired
    public AuthService(LoggingUtils loggingUtils, UserRepository userRepository, CommonValidator commonValidator)
    {
        this.loggingUtils = loggingUtils;
        this.userRepository = userRepository;
        this.commonValidator = commonValidator;
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

            User user = User
                    .builder()
                    .username(request.getUsername())
                    .fullName(request.getFullName())
                    .email(request.getEmail())
                    .password(request.getPassword())
                    .build();
            userRepository.save(user);

            //Set error Schema
            errorSchema.setSuccessResponse("Sukses", "Success");

            //response data
            responseData.setMessage("TEST");

            //return via template
            BaseResponse response = new BaseResponse();
            response.setErrorSchema(errorSchema);
            return response;
    }

}
