package spring.template.demo.utils.configuration;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.handler.WebRequestHandlerInterceptorAdapter;

import java.util.Locale;

public class RequestInterceptor extends WebRequestHandlerInterceptorAdapter {

    public RequestInterceptor(WebRequestInterceptor requestInterceptor) {
        super(requestInterceptor);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String lang = request.getHeader("Accept-Language");
        if(lang != null && !lang.isEmpty()){
            Locale locale = Locale.forLanguageTag(lang);
            LocaleContextHolder.setLocale(locale);
        }
        return true;
    }
}
