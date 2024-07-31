package group.bootcamp.technicaltest.common.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Component
@Profile("prod")
public class SynchronizeDataJob {

    private AtomicLong atomicLong = new AtomicLong(0);

    @Scheduled(timeUnit = TimeUnit.SECONDS, initialDelay = 2, fixedDelay =  5)

    public void runJob(){
        Long value = atomicLong.incrementAndGet();
        log.info("{} Run job {}", value, Thread.currentThread().getName());
    }

    //* spring cron not same with unit cron
    @Scheduled(cron = "1 * * * * *")
    public void runJobEveryMinute(){
        log.info("Run synchronize job every minutes");
    }
//        * * * * *: Menjalankan tugas setiap menit.
//        0 * * * *: Menjalankan tugas setiap jam pada menit ke-0.
//        0 0 * * *: Menjalankan tugas setiap hari pada pukul 12 malam.
//        0 0 1 * *: Menjalankan tugas setiap bulan pada tanggal 1 pada pukul 12 malam.
//        0 0 * * 5: Menjalankan tugas setiap Jumat pada pukul 12 malam.
//        0 0 1 1 *: Menjalankan tugas setiap tahun pada tanggal 1 Januari pada pukul 12 malam.

}
