package com.spring.app.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAspect {

     private static final Logger logger = Logger.getLogger(LoggingAspect.class.getName());



    @Around("execution(* com.spring.app.controller.*.*(..))")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{
        long begin = System.currentTimeMillis();

        Object result = proceedingJoinPoint.proceed();

        long end = System.currentTimeMillis();

        String duration = String.valueOf(end - begin);

        logger.info(duration);

        return result;
    }
}
