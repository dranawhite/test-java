package com.dranawhite.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 作用于注解上的通知
 *
 * @author liangyq 2017/8/18
 */
@Aspect
@Component
public class PersonAnnotationAdvice {

    @Around("@annotation(com.dranawhite.spring.aop.Tag)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        return null;
    }

}
