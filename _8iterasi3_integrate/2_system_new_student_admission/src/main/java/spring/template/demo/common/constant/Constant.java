package spring.template.demo.common.constant;

import org.springframework.boot.context.properties.ConfigurationProperties;

public class Constant {

    public static class EndPoint{

        public static final String PATH_PREFIX = "api/v1/";
        public static final String USER_PREFIX = PATH_PREFIX + "user/";
        public static final String LOGIN_PATH = "login";
        public static final String REGISTER_PATH = "register";


        public static final String NEED_AUTHENTICATED = "/api/v1/**";
        //wild card endpoint
        public static final String FAQ = PATH_PREFIX + "faq";

        public static final String FULL_REGISTER = USER_PREFIX + REGISTER_PATH;
        public static final String FULL_LOGIN = USER_PREFIX + LOGIN_PATH;
        public static final String ERROR = "/error";
    }

    @ConfigurationProperties(prefix = "configuration.security.jwt")
    public static class SecurityConstant{
        public static String SECRET_KEY;
        public static String HTTP_HEADER_KEY;

    }
}
