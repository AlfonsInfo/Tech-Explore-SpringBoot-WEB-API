package group.learn.async;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;


@Slf4j
@Component
public class HelloAsync {

    @Async
    @SneakyThrows
    public void hello(){
        //thread sleep tidak ditungguin
        Thread.sleep(2000L);
        log.info("run hello after 2 second {}", Thread.currentThread());
    }

    @Async
    @SneakyThrows
    public Future<String> hello(final String name){
        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(4000L);
        future.complete("Hello " + name + " from thread " + Thread.currentThread());
        return future;
    }

    @Async
    @SneakyThrows
    public Future<String> helloLagi(final String name){
        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(4000L);
        future.complete("Hello " + name + " from thread " + Thread.currentThread());
        return future;
    }
}
