package com.example.SpringAOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

    private static final Logger log= LoggerFactory.getLogger(PerformanceMonitorAspect.class);

//    @Around("execution(* com.example.SpringAOP.service.JobService.getAllJobs(..))")
//    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
//        long start=System.currentTimeMillis();
//
//        Object obj=jp.proceed();
//
//        long end=System.currentTimeMillis();
//        log.info("Time taken:"+(end-start)+"ms");
//        return obj;
//    }

    // For all methods, we use '*'
    @Around("execution(* com.example.SpringAOP.service.JobService.*(..))")
    public Object monitorTime(ProceedingJoinPoint jp) throws Throwable {
        long start=System.currentTimeMillis();

        Object obj=jp.proceed();

        long end=System.currentTimeMillis();
        log.info("Time taken:"+jp.getSignature().getName()+" "+(end-start)+"ms");
        return obj;
    }
}
