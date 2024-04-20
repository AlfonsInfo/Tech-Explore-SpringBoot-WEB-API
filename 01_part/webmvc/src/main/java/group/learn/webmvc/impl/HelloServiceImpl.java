package group.learn.webmvc.impl;

import group.learn.webmvc.service.HelloService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String nama) {
        if(Objects.isNull(nama)){
            return "Hello Guest";
        }else{
            return "Hello " + nama;
        }
    }
}
