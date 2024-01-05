package spring.template.demo.utils;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    private final LoggingUtils loggingUtils;
    @Autowired
    public LoggingAspect(LoggingUtils loggingUtils)
    {
        this.loggingUtils = loggingUtils;
    }
    @Pointcut("execution(* spring.template.demo..service..*(..))")
    public void serviceMethod(){}

    @Before("serviceMethod()")
    public void logBeforeCall(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info(loggingUtils.logFunction(className, methodName, "START POSITION"));
    }

    @After("serviceMethod()")
    public void logAfterCall(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        log.info(loggingUtils.logFunction(className, methodName, "AFTER EXECUTION"));
    }
}
