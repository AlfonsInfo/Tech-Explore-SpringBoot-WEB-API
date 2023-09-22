package belajar.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//Manually include package outside basePackage of main
@SpringBootApplication(scanBasePackages = {
		"belajar.springboot",
		"belajar.util"})
public class SpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
