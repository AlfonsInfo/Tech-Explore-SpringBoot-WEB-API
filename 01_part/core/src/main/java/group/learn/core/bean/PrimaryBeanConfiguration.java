package group.learn.core.bean;

import group.learn.core.classtarget.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PrimaryBeanConfiguration {


    @Primary
    @Bean(value = "fooPrimary")
    public Foo foo1(){
        return new Foo();
    }
    @Bean(value = "foo")
    public Foo foo2(){
        return new Foo();
    }

}
