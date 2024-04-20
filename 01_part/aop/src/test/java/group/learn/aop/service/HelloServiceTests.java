package group.learn.aop.service;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloServiceTests {

    @Autowired
    private HelloService helloService;

    @Test
    void helloSerivce(){
        Assertions.assertEquals("hello",helloService.hello());
    }
}
