package com.neoteric.javatdd.AOP;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeCalucation {
    @Around("@annotation(TimeExecution)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
