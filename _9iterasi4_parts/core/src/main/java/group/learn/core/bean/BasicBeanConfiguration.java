package group.learn.core.bean;

import group.learn.core.classtarget.Foo;
import group.learn.core.configuration.ConfigurationExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BasicBeanConfiguration {
    @Bean
    public Foo foo(){
        Foo foo = new Foo();
        return foo;
    }
}

class Main{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BasicBeanConfiguration.class);

        //Singleton
        Foo foo1 = context.getBean(Foo.class);
        Foo foo2 = context.getBean(Foo.class);
        Foo fooNotFromBean = new Foo();
        System.out.println(foo1.hashCode());
        System.out.println(foo2.hashCode());
        // not same objects
        System.out.println(fooNotFromBean.hashCode());
        System.out.println(foo1.hashCode() == foo2.hashCode());
    }
}

