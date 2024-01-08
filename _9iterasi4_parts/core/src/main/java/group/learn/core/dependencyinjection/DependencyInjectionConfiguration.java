package group.learn.core.dependencyinjection;

import group.learn.core.classtarget.Bar;
import group.learn.core.classtarget.Foo;
import group.learn.core.classtarget.FooBar;
import group.learn.core.configuration.ConfigurationExample;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyInjectionConfiguration {
    @Bean
    public Foo foo1(){
        return new Foo();
    }


    @Bean(value = "beanFoo")
    public Foo foo2(){
        return new Foo();
    }
    @Bean
    public Bar bean(){
        return new Bar();
    }

    @Bean
    public FooBar fooBar(@Qualifier("beanFoo") Foo foo, Bar bar){
        return new FooBar(foo, bar);
    }
}

class Main1{
    public static void main(String[] args) {
        withoutDependencyInjection();
        ApplicationContext context = new AnnotationConfigApplicationContext(DependencyInjectionConfiguration.class);
        Foo foo= context.getBean("beanFoo", Foo.class);
        FooBar fooBar = context.getBean(FooBar.class);

        System.out.println(foo.hashCode());
        System.out.println(fooBar.getFoo().hashCode());
    }

    private static void withoutDependencyInjection() {
        Foo foo = new Foo();
        Bar bar = new Bar();

        FooBar fooBar = new FooBar(foo,bar);
    }
}