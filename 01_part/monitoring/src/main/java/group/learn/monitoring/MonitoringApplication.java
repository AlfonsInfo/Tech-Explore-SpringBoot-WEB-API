package group.learn.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MonitoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplication.class, args);
	}

}

//url/actuator

//default active : health
//another feature : beans (check beans apa aja yang ada)


//beans
//http://localhost:8080/actuator/beans
//health (HealthIndicator)
//