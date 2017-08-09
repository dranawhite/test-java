package com.dranawhite.pattern.dynamicproxy;

import org.junit.Test;

/**
 * @author dranawhite 2017/8/9
 * @version 1.0
 */
public class PersonTest {

    @Test
    public void testSay() {
        PersonInvocationHandlerImpl personInvocationHandler = new PersonInvocationHandlerImpl();
        IPerson person = personInvocationHandler.getPersonProxy();
        person.say();
    }

    @Test
    public void testSayAgain() {
        PersonInvocationHandlerImpl personInvocationHandler = new PersonInvocationHandlerImpl();
        IPerson person = personInvocationHandler.getPersonProxy();
        person.sayAgain();
    }

}
