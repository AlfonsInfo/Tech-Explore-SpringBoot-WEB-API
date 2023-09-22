package restfulAPI.restful.controller;

import io.swagger.v3.oas.models.headers.Header;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import restfulAPI.restful.dto.ApiResponse;
import restfulAPI.restful.dto.ErrorMessageResponse;
import restfulAPI.restful.dto.ErrorSchema;
import restfulAPI.restful.dto.request.register.UserRegisRequest;
import restfulAPI.restful.dto.request.register.UserRegisRequest2;
import restfulAPI.restful.dto.response.UserRegisResponse;
import restfulAPI.restful.service.UserService;
import restfulAPI.restful.service.ValidationService;
import restfulAPI.restful.utils.security.HeaderCheckUtil;

@RestController
@RequestMapping("api")
public class UserController {
    @Autowired
    private UserService userService;
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private ValidationService validationService;


    @Autowired
    private HeaderCheckUtil headerCheckUtil;
    //Menggunakan Request Param` dan Request Part
    @PostMapping(
            path = "/auth/register",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<UserRegisResponse> registerWithRequestParam(HttpServletRequest request, @RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("email") String email, @RequestParam("role") String role, @RequestPart("fotoProfil") MultipartFile file
    ) {
        UserRegisRequest userRegisRequest = new UserRegisRequest();
            try {
                userRegisRequest.setUsername(username);
                userRegisRequest.setPassword(password);
                userRegisRequest.setEmail(email);
                userRegisRequest.setRole(role);
                userRegisRequest.setFotoProfil(file.getBytes());
                logger.debug("sampai sini lohh");
            } catch (Exception e) {
                // Tangani kesalahan
                logger.debug("Woy salah {}", e.getMessage());
            }
        UserRegisResponse userRegisResponse = userService.register(userRegisRequest);
        return new ResponseEntity<>(userRegisResponse, HttpStatus.OK);
    }

    //@RequestBody Tidak bisa handle file

    //Menggunakan Modal Attribute
    @PostMapping(
            path = "/auth/register2",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ApiResponse<UserRegisResponse> registerWithModalAttribute(HttpServletRequest ServletRequest,@ModelAttribute UserRegisRequest2 request)
    {
        //factory utils for abstraction
//        System.out.println("Header : " + ServletRequest.getHeader("USER_UUID"));
        headerCheckUtil.usernameCheck(ServletRequest.getHeader("USER_UUID"));
        validationService.validate(request);
        System.out.println("Requestnya ini" + request);

        UserRegisResponse response = userService.register2(request);

        ErrorSchema errorSchema = new ErrorSchema();
        errorSchema.setSuccessResponse();

        return  new  ApiResponse<UserRegisResponse>(response, errorSchema);
    }
}
