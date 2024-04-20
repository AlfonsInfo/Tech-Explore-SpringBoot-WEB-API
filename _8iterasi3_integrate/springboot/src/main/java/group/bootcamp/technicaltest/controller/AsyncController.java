package group.bootcamp.technicaltest.controller;


import group.bootcamp.technicaltest.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/async-demo")
public class AsyncController {

    @Autowired
    OrderService orderService;
    //Idenya ada transaksi -> send email & notify
    @GetMapping("/non-async")
    public ResponseEntity<String> nonAsyncDemo() throws InterruptedException {
        //* Proses Update Data di DB
        //* Send Email
        Thread.sleep(2000);
        //* Notify
        Thread.sleep(2000);

        return ResponseEntity.ok("");
    }

    //Idenya ada transaksi -> send email & notify
    @GetMapping("async")

    public ResponseEntity<String> asyncDemo() throws InterruptedException {
        //* Proses Update Data di DB
        //* Send Email
        orderService.buyProduct();
        return ResponseEntity.ok("");
    }
}
