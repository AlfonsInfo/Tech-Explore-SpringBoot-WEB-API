package group.learn.webmvc.controller;

import group.learn.webmvc.data.EndPointConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class RequestHeaderController {

    @GetMapping(EndPointConstant.HEADER)
    public String header(@RequestHeader(name="X-TOKEN") String token){
        if(Objects.equals(token,"ini token")){
            return "OKEEEE";
        }else{
            return "TOKEN SALAH BROO";
        }
    }
}
