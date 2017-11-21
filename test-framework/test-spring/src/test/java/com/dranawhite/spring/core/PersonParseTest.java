package com.dranawhite.spring.core;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dranawhite 2017/11/7
 * @version 1.0
 */
public class PersonParseTest {

    private Person person;
    private static ClassPathXmlApplicationContext ctx;

    @BeforeClass
    public static void init() {
        ctx = new ClassPathXmlApplicationContext("classpath:core/applicationContext-core.xml");
    }

    @Test
    public void testPerson() {
        person = (Person) ctx.getBean("person");
        System.out.println(person.toString());
        Assert.assertNotNull(person);
    }

}
