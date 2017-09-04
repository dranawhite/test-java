package com.dranawhite.springmvc.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author dranawhite 2017/9/4
 * @version 1.0
 */
@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        System.out.println("Exception Handler!");
        System.out.println(e.getMessage());
    }

}
