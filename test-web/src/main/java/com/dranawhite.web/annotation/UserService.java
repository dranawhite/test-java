package com.dranawhite.web.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author dranawhite.web.jvm.jvm 2017/7/4
 * @version 1.0
 */
public class UserService {

    @PostConstruct
    public void init() {
        System.out.println("Init Method!");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destory Method!");
    }

}
