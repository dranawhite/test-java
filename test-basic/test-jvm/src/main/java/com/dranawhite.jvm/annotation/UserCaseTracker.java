package com.dranawhite.jvm.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author dranawhite.web.jvm 2017/7/4
 * @version 1.0
 */
class UserCaseTracker {

    /**
     * 解析UserCase注解
     * @param cls UserCase注解标注的类
     */
    public void annotation(Class cls) {
        Method[] methods = cls.getDeclaredMethods();
        for (Method method : methods) {
            Annotation[] annotation = method.getAnnotationsByType(UserCase.class);
            if (annotation != null) {
                UserCase userCase = (UserCase) annotation[0];
                System.out.println("ID: " + userCase.id());
                System.out.println("DESC: " + userCase.description());
            }
        }
    }

}
