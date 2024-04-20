package group.learn.configproperties;

import group.learn.configproperties.resource.ResourceLoaderExample;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

@SpringBootApplication
public class ConfigPropertiesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigPropertiesApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ResourceLoaderExample resourceLoaderExample) {
		return args -> {
			resourceLoaderExample.usingResourceLoader();
		};
	}

}
