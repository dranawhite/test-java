package com.dranawhite.spring.aop;

import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author dranawhite 2017/8/17
 * @version 1.0
 */
public class PersonTest {

    @Test
    public void testSay_before() {
        //创建代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        //射入目标类对象
        proxyFactory.setTarget(new Person());
        //添加前置增强
        proxyFactory.addAdvice(new PersonBeforeAdvice());
        //添加后置增强
        proxyFactory.addAdvice(new PersonAfterAdvice());
        //从代理工厂中获取代理
        Person person = (Person) proxyFactory.getProxy();
        //执行代理方法
        person.say();
    }

    @Test
    public void testSay_around() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Person());
        proxyFactory.addAdvice(new PersonAroundAdvice());
        Person person = (Person) proxyFactory.getProxy();
        person.say();
    }

    @Test
    public void testSay_throw() {
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.setTarget(new Person());
        proxyFactory.addAdvice(new PersonThrowAdvice());
        Person person = (Person) proxyFactory.getProxy();
        person.sayNull();
    }

    @Test
    public void testSay_around_xml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/applicationContext.xml");
        Person person = (Person) ctx.getBean("proxyFactoryBean");
        person.say();
    }

    @Test
    public void testSay_introduction_xml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/applicationContext.xml");
        Person person = (Person) ctx.getBean("proxyFactoryBean");
        person.say();
        Apolopy apolopy = (Apolopy) person;
        apolopy.sayAgain();
    }

    @Test
    public void testSay_advisor_xml() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/applicationContext.xml");
        Person person = (Person) ctx.getBean("proxyAdvisorFactoryBean");
        person.say();
        person.sayGoodMorning();
        person.sayGoodEvening();
    }

}
