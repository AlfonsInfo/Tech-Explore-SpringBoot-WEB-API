package group.learn.core.bean;

import group.learn.core.classtarget.Bar;
import group.learn.core.classtarget.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
public class LazyBean {
    @Bean
    @Lazy
    public Foo foo(){
      log.info("neww");
      return new Foo();
    }

    @DependsOn(value = {"foo"}) // dibuat setelah boo dibuat
    public Bar bar(){
        return new Bar();
    }
}
