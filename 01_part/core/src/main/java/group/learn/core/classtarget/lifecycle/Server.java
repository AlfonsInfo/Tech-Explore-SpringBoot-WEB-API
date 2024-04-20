package group.learn.core.classtarget.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server {

    @PostConstruct // method yang dipanggil ketika bean selesia dibuat
    public void start(){
      log.info("server start");
    }

    @PreDestroy // method dipanggil kietka bean selesai dhancurkan
    public void close(){
        log.info("server close");
    }
}
