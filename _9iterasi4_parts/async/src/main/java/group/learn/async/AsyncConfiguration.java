package group.learn.async;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class AsyncConfiguration {

    //thread executors , by default udh dibuatin spring, tp jika mau buat sendiri bisa
//    @Bean
//    public Executor taskExecutor(){
//        return Executors.newThreadPerTaskExecutor();
//    }


    @Bean
    public Executor singleTaskExecutor(){
        return Executors.newSingleThreadExecutor();
    }


    //Untuk Scheduler
    @Bean
    public ScheduledExecutorService taskScheduler(){
        return Executors.newScheduledThreadPool(10);
    }
}
