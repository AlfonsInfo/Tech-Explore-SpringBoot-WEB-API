package group.bootcamp.technicaltest.common.resolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class ResolverConfiguration {
    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver slr = new SessionLocaleResolver();
        Locale localeId = new Locale("id", "ID");
        slr.setDefaultLocale(localeId);
        return slr;
    }
}
