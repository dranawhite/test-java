package com.dranawhite.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author dranawhite 2017/12/19
 * @version 1.0
 */
public class AutowiredPro {

    @Autowired
    @Qualifier("personImpl")
    private IPerson person;

    @Autowired
    private List<IPerson> personList;

    @Override
    public String toString() {
        return person.sleep();
    }

    public void print() {
        for (IPerson person : personList) {
            System.out.println(person.sleep());
        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext
                ("beans/applicationContext-person.xml");
        AutowiredPro pro = ctx.getBean("pro", AutowiredPro.class);
        System.out.println(pro.toString());
        System.out.println("=============");
        pro.print();
    }

}
