package com.bca.itworks.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloWorldController {

    @GetMapping
    public String index()
    {
        return "Hello World";
    }

    @GetMapping("hi")
    public String hi()
    {
        return "Hi World";
    }
}
