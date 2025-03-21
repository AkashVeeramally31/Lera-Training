package com.example.SpringAOP.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {

    private static final Logger log= LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.example.SpringAOP.service.JobService.getJob(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint jp,int postId) throws Throwable {

        if(postId<0){
            log.info("Post Id is negative, updating id");
            postId = -postId;
            log.info("new value:"+postId);
        }

        Object obj=jp.proceed(new Object[]{postId});

        return obj;
    }
}

