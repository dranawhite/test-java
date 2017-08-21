package com.dranawhite.spring.aop;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 后置通知
 *
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
@Component
public class PersonAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target)
            throws Throwable {
        System.out.println("Spring AOP——后置通知");
    }
}
