package com.dranawhite.pattern.dynamicproxy;

import org.junit.Test;

/**
 * @author dranawhite 2017/8/9
 * @version 1.0
 */
class PersonTest {

    @Test
    public void testSay_Dynamicproxy() {
        PersonInvocationHandlerImpl personInvocationHandler = new PersonInvocationHandlerImpl();
        IPerson person = personInvocationHandler.getPersonProxy();
        person.say();
    }

    @Test
    public void testSayAgain_Dynamicproxy() {
        PersonInvocationHandlerImpl personInvocationHandler = new PersonInvocationHandlerImpl();
        IPerson person = personInvocationHandler.getPersonProxy();
        person.sayAgain();
    }

    @Test
    public void testSay_Cglib() {
        CGLibInterceptor cgLibInterceptor = new CGLibInterceptor();
        Person person = cgLibInterceptor.getProxy(Person.class);
        person.say();
    }

    @Test
    public void testSayAgain_Cglib() {
        CGLibInterceptor cgLibInterceptor = new CGLibInterceptor();
        Person person = cgLibInterceptor.getProxy(Person.class);
        person.sayAgain();
    }

}
