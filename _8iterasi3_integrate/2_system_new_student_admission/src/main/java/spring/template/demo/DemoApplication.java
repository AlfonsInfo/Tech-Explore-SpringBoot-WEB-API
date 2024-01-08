package spring.template.demo;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.TimeZone;

@SpringBootApplication
public class DemoApplication {

	@PostConstruct
	public void initTime()
	{
		TimeZone.getTimeZone("Asia/Jakarta");
	}


	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
