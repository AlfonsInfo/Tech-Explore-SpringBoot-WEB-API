package spring.template.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import spring.template.demo.common.interceptor.ChannelInterceptor;
import spring.template.demo.common.interceptor.LocaleInterceptor;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    @Autowired
    private ChannelInterceptor channelInterceptor;
    @Autowired
    private LocaleInterceptor localeInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(channelInterceptor);
        registry.addInterceptor(localeInterceptor);
    }
}
