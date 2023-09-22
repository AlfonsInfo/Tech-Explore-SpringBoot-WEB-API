package belajar.springboot;

import belajar.springboot._03hibernate.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.IOException;


//Manually include package outside basePackage of main
@Slf4j
@SpringBootApplication(scanBasePackages = {
		"belajar.springboot",
		"belajar.util"})
public class SpringbootApplication {
	@Autowired
	private BufferedReader reader;
	@Autowired
	private StudentService studentService;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(String[] args)
	{
		return args1 -> {/*runCommandLineCRUDExample();*/};
	}

	public  void runCommandLineCRUDExample () throws IOException {
		System.out.println("1. Create Random Student");
		System.out.println("2. Read Data Student");
		System.out.println("3. Update Data Student");
		System.out.println("4. Delete Data Student");
		System.out.println("Pilih :");
		String input = reader.readLine();
		switch (input){
			case "1" :
				studentService.createRandomStudent();
				break;
			case "2" :
				studentService.readAllStudent();
				break;
			case "3" :
				studentService.readAllStudent();
				System.out.println("Masukkan nomor data yang ingin di update "); input = reader.readLine();
				studentService.update(Integer.parseInt(input));
				break;
			case "4" :
				studentService.readAllStudent();
				System.out.println("Masukkan nomor data yang ingin di update "); input = reader.readLine();
				studentService.delete(Integer.parseInt(input));
				break;
		}
	}

}
