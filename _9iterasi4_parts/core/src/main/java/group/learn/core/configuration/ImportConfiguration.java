package group.learn.core.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
class FooConfiguration{

}

@Configuration
class BarConfiguration{

}


@Configuration
@Import(value = {
        FooConfiguration.class,
        BarConfiguration.class
})
public class ImportConfiguration {
}
