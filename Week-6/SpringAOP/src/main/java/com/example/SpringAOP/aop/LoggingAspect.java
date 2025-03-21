package com.example.SpringAOP.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger log= LoggerFactory.getLogger(LoggingAspect.class);

    // Syntax: - return type, class-name.method-name, arguments
    // Here (* *.*(..)) indicates that we need to return all from all classes and all methods that why
    // we use '*' and for arguments we use '..' to get all arguments.
    // @Before("execution(* *.*(..))") -> includes all classes with all methods

    // com.example.SpringAOP.service.JobService -> class-name (includes only JobService class)
    // @Before("execution(* com.example.SpringAOP.service.JobService.*(..))")
    // public void logMethodCall(){
    //     log.info("Method called");
    // }

    // The above advice will execute for all methods present in the JobService, but if we want to
    // execute only for one method, we use 'JoinPoint'.
    //@Before("execution(* com.example.SpringAOP.service.JobService.getAllJobs(..))")
    //public void logMethodCall(JoinPoint jp){
    //   log.info("Method called: "+jp.getSignature().getName());
    //}

    // 'After'
    @After("execution(* com.example.SpringAOP.service.JobService.getAllJobs(..))")
    public void logMethodExecuted(JoinPoint jp){
        log.info("Method executed: {}", jp.getSignature().getName());
    }
}
