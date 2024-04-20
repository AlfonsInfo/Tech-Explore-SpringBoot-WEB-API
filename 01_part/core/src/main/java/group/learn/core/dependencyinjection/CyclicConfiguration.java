package group.learn.core.dependencyinjection;

import group.learn.core.classtarget.CyclicA;
import group.learn.core.classtarget.CyclicB;
import group.learn.core.configuration.ConfigurationExample;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class CyclicConfiguration {

    @Bean
    public CyclicA cyclicA(CyclicB cyclicB){
        return new CyclicA(cyclicB);
    }

    @Bean
    public CyclicB cyclicB(CyclicA cyclicA){
        return new CyclicB(cyclicA);
    }
}

class Main{
    public static void main(String[] args) {
    try{
        ApplicationContext context = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
//        System.out.println("It Must be fail because cyclic ?");
    }catch (BeansException exception){
        System.out.println("Cyclic bro");
    }
    }
}