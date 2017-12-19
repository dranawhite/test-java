package com.dranawhite.spring.beans;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author dranawhite 2017/12/19
 * @version 1.0
 */
@Component
@Order(2)
public class Person implements IPerson {

    @Override
    public String sleep() {
        return "I am sleeping!";
    }
}
