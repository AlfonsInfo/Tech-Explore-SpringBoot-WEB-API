package group.learn.configproperties.resource;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
public class ResourceLoaderExample implements ResourceLoaderAware {
    @Setter
    private ResourceLoader resourceLoader;

    public void usingResourceLoader(){
        log.info("calling");
        String resourceProtocolClassPath = "classpath:";
        String resourceProtocolFile = "file:";
        String resourceProtocolHttps = "https:";

        Resource resource = resourceLoader.getResource("classpath:/resource.txt");
        try {
            System.out.println(resource.getURL());
        } catch (IOException e) {
            log.info("error");
            throw new RuntimeException(e);
        }
    }
}
