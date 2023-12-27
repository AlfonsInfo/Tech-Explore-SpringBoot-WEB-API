//package spring.template.demo.utils.filter;
//
//
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//import spring.template.demo.repository.ChannelRepository;
//import spring.template.demo.utils.LoggingUtils;
//import spring.template.demo.utils.exception.CustomValidationException;
//
//import java.io.IOException;
//
//@Component
////@Order()
//@Slf4j
//public class ChannelFilter implements Filter {
//
//    @Autowired
//    private ChannelRepository channelRepository;
//
//    @Autowired
//    private LoggingUtils loggingUtils;
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        log.info(loggingUtils.logTemplate("CHANNEL FILTER", "START FUNCTION"));
//        String requestMethod = req.getMethod();
//        String path = req.getServletPath();
//        if(channelRepository.existsByPathAndRequestMethod(path,requestMethod)){
//            chain.doFilter(request,response);
//        }else{
//            // Not Catch by interceptor
//            throw new CustomValidationException("Channel id" , "Doesn't Exist");
//        }
//
//    }
//}
