package group.learn.webmvc.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
@RestController
public class CookieController {

    @PostMapping(path = "/login/cookie", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> loginSetCookie(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletResponse response
    ){
        if(Objects.equals(username,"alfons") && Objects.equals(password, "password")){
            Cookie cookie = new Cookie("username" , username);
            cookie.setPath("/"); // / bisa diakses dimanapun jika /namaPath path tertentu.... (prefix path)
            response.addCookie(cookie);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("NOT", HttpStatus.UNAUTHORIZED);
        }
    }

    @GetMapping("/user")
    public ResponseEntity<String> getUser(@CookieValue("username") String username){
        return new ResponseEntity<>("Hello " + username, HttpStatus.OK);
    }

}
