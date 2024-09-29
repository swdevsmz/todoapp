package com.todoapp.backapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@EnableAspectJAutoProxy
public class LoggingAspect {
    
    @Before("execution(public * *..*Controller.*(..))")
    public void before(JoinPoint jp) {
        log.info("@ aspect before: " + jp.toString());
    }

    @After(value="execution(public * *..*Controller.*(..))")
    public void after(JoinPoint jp) {
        log.info("@ aspect after: " + jp.toString());
    }

    @AfterReturning(value="execution(public * *..*Controller.*(..))", returning="returnValue")
    public void afterReturning(JoinPoint jp, Object returnValue) {
        log.info("@ aspect afterReturning: " + returnValue);
    }

}
