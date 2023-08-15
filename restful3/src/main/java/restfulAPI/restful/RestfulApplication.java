package restfulAPI.restful;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.TimeZone;

@SpringBootApplication
public class RestfulApplication {

	@PostConstruct // Dijalankan sekali saat aplikasi di run
	public void initTime()
	{
		TimeZone.getTimeZone("Asia/Jakarta"); //Apakah Butuh ?
	}


	public static void main(String[] args) {
//		SpringApplication.run(RestfulApplication.class, args);
		System.out.println(LocalDateTime.now());
	}

}
