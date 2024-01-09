package group.learn.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    //@Pointcut("expression")
    @Pointcut("target(group.learn.aop.service.HelloService)")
    public void helloServiceMethod(){}


    @Before("helloServiceMethod()")
    public void beforeHelloServiceMethod(JoinPoint joinPoint){
        String target = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        log.info("Before Target : " + target + "Method name : " + methodName  );
    }


    @After("helloServiceMethod()")
    public void afterHelloServiceMethod(){
        log.info("After HelloService Method");
    }
    //source semantic point cut

    @Around("helloServiceMethod()")
    public Object aroundHelloServiceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        String className  = joinPoint.getClass().getName();
        String method = joinPoint.getSignature().getName();

        try{
            log.info("before");
            return joinPoint.proceed(joinPoint.getArgs());
        } catch (Throwable throwable){
            log.info("Arround Error ");
            throw throwable;
        } finally {
            log.info("Finally");
        }
    }
}
