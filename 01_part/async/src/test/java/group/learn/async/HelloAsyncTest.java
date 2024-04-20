package group.learn.async;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest
public class HelloAsyncTest {
    @Autowired
    HelloAsync helloAsync;

    @Test
    void setHelloAsync() throws InterruptedException {
        for(int i = 0 ;i < 10 ; i ++){
            helloAsync.hello();
        }

        log.info("after call hello async");
        Thread.sleep(4000L);
    }

    @Test
    void helloName() throws ExecutionException, InterruptedException {
        Future<String> future = helloAsync.hello("alfons"); //proses ini tidak ditungguin
        log.info("nungguin ya ???");
        String response = future.get();
        log.info("nungguin ya ???");
        log.info(response);
    }


    @Test
    void helloLagi() throws ExecutionException, InterruptedException {
        Future<String> future = helloAsync.helloLagi("alfons"); //proses ini tidak ditungguin
        log.info("nungguin ya ???");
        String response = future.get();
        log.info("nungguin ya ???");
        log.info(response);
    }


}
