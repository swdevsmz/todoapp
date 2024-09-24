package com.todoapp.backapp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    
    Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @After("within(com.todoapp.backapp.presentation.controller.*Controller)")
    public void commonLog(JoinPoint jp) {
        logger.info("メソッド実行");
        logger.info("メソッド名" + jp.getSignature().toString());
        logger.warn("warnログ");
    }

}
