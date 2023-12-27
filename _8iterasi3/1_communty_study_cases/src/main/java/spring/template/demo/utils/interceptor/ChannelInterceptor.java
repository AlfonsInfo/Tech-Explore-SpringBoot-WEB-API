package spring.template.demo.utils.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import spring.template.demo.repository.ChannelRepository;
import spring.template.demo.utils.LoggingUtils;
import spring.template.demo.utils.exception.CustomValidationException;


//* interceptor is post processing of request */
@Slf4j
@Component
public class ChannelInterceptor  implements HandlerInterceptor {

    @Autowired
    private ChannelRepository channelRepository;

    @Autowired
    private LoggingUtils loggingUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info(loggingUtils.logTemplate("CHANNEL INTERCEPTOR", "START FUNCTION"));
        String requestMethod = request.getMethod();
        String path = request.getServletPath();
        if(channelRepository.existsByPathAndRequestMethod(path,requestMethod)){
            log.info(loggingUtils.logTemplate("INTERCEPTOR", "START FUNCTION"));
            return true;
        }else{
            throw new CustomValidationException("Channel id" , "Doesn't Exist");
        }

    }
}
