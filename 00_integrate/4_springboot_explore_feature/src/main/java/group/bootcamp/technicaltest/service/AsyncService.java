package group.bootcamp.technicaltest.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public void backgroundOperation(){
        try {
            //async or background work is performing here
            Thread.sleep(2000);
            Thread.sleep(4000);
            //emailService.sendEmail();
            //smsService.sendSMS();
        }
        catch (InterruptedException e) {
            System.out.println("Error while executing sleep in Thread for task: ");
            //gagal -> catat ke db -> job retry send email
        }finally {
            System.out.println("Success background operations");
        }
    }
}
