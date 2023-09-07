package restfulAPI.restful.utils.security;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
@Component
public class HeaderCheckUtil {

    public void usernameCheck(String Uuid){
        if(null == Uuid || "".equals(Uuid))
        {
            System.out.println("Masuk ke usernamea check");
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User Not Found");
        }else{

        }
    }
}
