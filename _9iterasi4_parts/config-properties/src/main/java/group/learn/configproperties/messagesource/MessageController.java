package group.learn.configproperties.messagesource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Value("${application.name}")
    private String name;
    @Autowired
    MessageSourceExample.SampeSource sampeSource;


    @Autowired
    Environment environment;

    @GetMapping("/")
    public String sayHello(){
        return sampeSource.helloYou();
    }

    @GetMapping("/app-properties")
    public String appProperties(){
        return name;
    }

    @GetMapping("/env")
    public String appEnv(){
        return environment.getProperty("JAVA_HOME");
    }
}
