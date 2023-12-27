package spring.template.demo.utils.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import spring.template.demo.utils.LoggingUtils;

import java.util.Locale;
@Slf4j
@Component
public class LocaleInterceptor implements HandlerInterceptor {

    @Autowired
    private LoggingUtils loggingUtils;

    @Override
    public boolean preHandle(HttpServletRequest request,  HttpServletResponse response, Object handler) {
        log.info(loggingUtils.logTemplate("LOCALE INTERCEPTOR","START FUNCTION"));
        String lang = request.getHeader("Accept-Language");
        if(lang != null && !lang.isEmpty()){
            Locale locale = Locale.forLanguageTag(lang);
            LocaleContextHolder.setLocale(locale);
        }
        return true;
    }
}
