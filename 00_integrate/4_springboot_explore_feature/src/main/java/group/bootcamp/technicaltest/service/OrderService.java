package group.bootcamp.technicaltest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    AsyncService asyncService;
    public void buyProduct(){
        //logic purchase & updating db

        //send email and notify run asynchronizely
        asyncService.backgroundOperation();
    }


}
