package belajar.springboot._01basic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Endpoint ("/basic/*);
@RestController
@RequestMapping("/basic")
public class ExampleRestController {


    @Value("${developer.is.name}")
    private String developerName;

    @Autowired
    private Environment environment;
    @GetMapping("/helloworld")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/helloworldbesar")
    public String forDemoDevTools()
    {
        return "<h1>Hello World</h1>";
    }

    @GetMapping("/applicationproperties")
    public String applicationProperties()
    {
        return developerName;
    }

    @GetMapping("/environment")
    public String getPropertyFromEnvironment()
    {
        return environment.getProperty("developer.is.name");
    }
}
