package com.example.spring.aop.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviseConfig{
    private static final Logger log = LoggerFactory.getLogger(AdviseConfig.class);

    @Pointcut(value = "execution(* com.example.spring.aop.*.*.*(..))")
    public void myLoggingPointCut(){
        log.info("myLoggingPointCut start calling ....");

    }


    @Around("myLoggingPointCut()")
    public Object loggingAdvise(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        ObjectMapper mapper = new ObjectMapper();
        final String classname = proceedingJoinPoint.getTarget().getClass().getName();
        final String methodName = proceedingJoinPoint.getSignature().getName();
        final Object[] methodArgrs = proceedingJoinPoint.getArgs();
        final String methodParams = mapper.writeValueAsString(methodArgrs);
        log.info("class name : {} , method name : {} , method argrument : {} ",classname,methodName,methodParams);
        final Object responseObj = proceedingJoinPoint.proceed();
        log.info("class name : {} , method name : {} ,response : {} ",classname,methodName,mapper.writeValueAsString(responseObj));

        return responseObj;


    }
}
