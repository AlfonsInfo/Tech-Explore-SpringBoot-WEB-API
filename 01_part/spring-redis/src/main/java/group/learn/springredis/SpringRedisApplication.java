package group.learn.springredis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRedisApplication.class, args);
	}

	//RedisTemplate : : Berinteraksi dengan database redis RedisTemplate<key,value>
	//StringRedisTemplate implementasi dari RedisTemplate

	//Value Operations (interfaces)
}
