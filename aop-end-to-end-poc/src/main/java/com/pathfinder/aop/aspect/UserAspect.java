package com.pathfinder.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class UserAspect{
    private static final Logger logger = LoggerFactory.getLogger(UserAspect.class);

    @Before("execution(* com.pathfinder.aop.controller.*.*(..))")
    public void beforeAdviseController(JoinPoint joinPoint){
        final String methodName = joinPoint.getSignature().getName();
        final Object[] payload = joinPoint.getArgs();
        logger.info("Before controller method invoked : {} with payload : {}",methodName,payload);

    }

    @After("execution(* com.pathfinder.aop.controller.*.*(..))")
    public void  afterAdviseController(JoinPoint joinPoint){
        final String methodName = joinPoint.getSignature().getName();
        final Object[] payload = joinPoint.getArgs();
        logger.info("After controller method invoked : {} ",methodName);

    }

    @Before("execution(* com.pathfinder.aop.service.*.*(..))")
    public void beforeAdviseService(JoinPoint joinPoint){
        final String methodName = joinPoint.getSignature().getName();
        final Object[] payload = joinPoint.getArgs();
        logger.info("Before Service method invoked : {} with payload : {}",methodName,payload);

    }

    @After("execution(* com.pathfinder.aop.service.*.*(..))")
    public void  afterAdviseService(JoinPoint joinPoint){
        final String methodName = joinPoint.getSignature().getName();
        final Object[] payload = joinPoint.getArgs();
        logger.info("After Service method invoked : {}",methodName);
    }

    @AfterReturning(value = "execution(* com.pathfinder.aop.service.*.*(..))" , returning = "userObject")
    public void  afterReturningAdviseService(JoinPoint joinPoint , Object userObject){
        final String methodName = joinPoint.getSignature().getName();
        final Object[] payload = joinPoint.getArgs();
        logger.info("After returning Service method invoked : {} with response : {}",methodName,userObject);
    }
    @AfterThrowing(value = "execution(* com.pathfinder.aop.service.*.*(..))" , throwing = "exception")
    public void  afterExceptiongAdviseService(JoinPoint joinPoint , Exception exception){
        final String methodName = joinPoint.getSignature().getName();
        final Object[] payload = joinPoint.getArgs();
        logger.info("After throwing  Service method invoked : {} with exception : {}",methodName,exception);
    }

    @Around("execution(* com.pathfinder.aop.service.*.*(..))")
    public Object aroundAdviseService(JoinPoint joinPoint) throws Throwable{
        final String methodName = joinPoint.getSignature().getName();
        final Object[] payload = joinPoint.getArgs();
        logger.info("Around Service method invoked : {} with payload : {}",methodName,payload);
        Object proceed = null;
        try{
            proceed = ((org.aspectj.lang.ProceedingJoinPoint) joinPoint).proceed();
        }catch (Throwable throwable){
            logger.error("Exception in around advise : {}",throwable.getMessage());
            throw throwable;
        }
        logger.info("Around Service method invoked : {} with response : {}",methodName,proceed);
        return proceed;
    }
}
