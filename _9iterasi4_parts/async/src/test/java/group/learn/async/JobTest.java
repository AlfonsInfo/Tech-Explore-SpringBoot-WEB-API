package group.learn.async;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class JobTest {
    @Autowired
    Job job;


    @Test
    void jobTest() throws InterruptedException {
        Thread.sleep(4000L);
        System.out.println("yoo");
        Assertions.assertEquals(2L,job.getValue());
    }

    @Test
    void test() throws InterruptedException {
        //check log cron job
        Thread.sleep(4000L);
    }
}
