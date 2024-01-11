package group.learn.webmvc.controller;

import group.learn.webmvc.data.User;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
@RestController
public class SessionController {

    @PostMapping(path = "/login/session", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> loginSetCookie(
            @RequestParam(name = "username") String username,
            @RequestParam(name = "password") String password,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        if(Objects.equals(username,"alfons") && Objects.equals(password, "password")){
            HttpSession session = request.getSession(true);
            session.setAttribute("user", new User(username));
            Cookie cookie = new Cookie("username" , username);
            cookie.setPath("/"); // / bisa diakses dimanapun jika /namaPath path tertentu.... (prefix path)


            response.addCookie(cookie);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("NOT", HttpStatus.UNAUTHORIZED);
        }
    }
}
