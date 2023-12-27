package spring.template.demo.entities.constant;

public class Constant {

    public static class EndPoint{

        public static final String PATH_PREFIX = "api/v1/";
        public static final String USER_PREFIX = PATH_PREFIX + "user/";
        public static final String FAQ_PREFIX = PATH_PREFIX + "faq/";
        public static final String LOGIN_PATH = "login";
        public static final String REGISTER_PATH = "register";


        //wild card endpoint
        public static final String NEED_AUTHENTICATED = "/api/v1/*";

        public static final String FULL_FAQ = PATH_PREFIX + FAQ_PREFIX;
    }
}
