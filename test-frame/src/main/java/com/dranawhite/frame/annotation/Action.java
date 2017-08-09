package com.dranawhite.frame.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Action方法注解
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    /**
     * 请求类型与路径
     * @return 路径
     */
    String value();

}
