package com.dranawhite.spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
@Configuration
public class PersonBuilder {

    @Bean("personAnno")
    public Person buildPerosn() {
        Person pn = new Person();
        pn.setAge(15);
        pn.setId("01");
        pn.setName("test");
        return pn;
    }

}
