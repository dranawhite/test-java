package com.dranawhite.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author liangyq 2017/12/18
 */
public class ApplicationContextPro {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("beans/applicationContext-beans.xml");
        Car car = (Car) ctx.getBean("car");
        car.introduce();
    }

}
