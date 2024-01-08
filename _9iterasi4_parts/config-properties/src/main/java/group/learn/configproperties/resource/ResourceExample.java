package group.learn.configproperties.resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;

public class ResourceExample {
    public static void useResource(){
        Resource resource = new ClassPathResource("/application.properties");
        try {
            System.out.println(resource.getFilename());
            System.out.println(resource.getURL());
            System.out.println(resource.getFile().getAbsoluteFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
