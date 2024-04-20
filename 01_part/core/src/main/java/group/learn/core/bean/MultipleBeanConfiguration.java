package group.learn.core.bean;

import group.learn.core.classtarget.Foo;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class MultipleBeanConfiguration {
    @Bean
    public Foo foo1(){
        return new Foo();
    }

    @Bean
    public Foo foo2(){
        return new Foo();
    }
}

class Main2{
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MultipleBeanConfiguration.class);

        //Singleton
        Foo foo1 = context.getBean("foo1" ,Foo.class);
        Foo foo2 = context.getBean("foo2" , Foo.class);
        System.out.println(foo1.hashCode());
        System.out.println(foo2.hashCode());
        // not same objects
        System.out.println(foo1.hashCode() != foo2.hashCode());
    }
}
