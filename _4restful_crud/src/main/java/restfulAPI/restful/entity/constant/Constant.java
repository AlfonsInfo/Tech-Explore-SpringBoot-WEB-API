package restfulAPI.restful.entity.constant;

public class Constant {

    public static final String SERVICE_NAME = "";
    public static class HttpHeader{
        public static final String HEADER_USER = "";
        public static final String HEADER_VALUE = "application/json";
    }
    public static class ErrorHttpCode{

        public static String SUCCESS = "200";
        public static String BAD_REQUEST = "400";

        public static String PROCESS_SUCCESS_BUT_NOT_FOUND = "202";
    }

    public static class ErrorMessage{
        public static class IdMessage{
            public static String SUCCESS = "Sukses";
            public static String BAD_REQUEST = "Permintaan Tidak Valid";
        }

        public static class EnMessage{

            public static String SUCCESS = "Success";
            public static String BAD_REQUEST = "Request Not Valid";
        }
    }

    public static class DateFormat{

    }


}
