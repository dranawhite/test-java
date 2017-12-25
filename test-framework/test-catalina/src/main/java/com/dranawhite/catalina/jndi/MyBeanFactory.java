package com.dranawhite.catalina.jndi;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.RefAddr;
import javax.naming.Reference;
import javax.naming.spi.ObjectFactory;

/**
 * <pre>
 *     每次调用lookup()方法，即调用一次该类的getObjectInstant()方法
 * </pre>
 *
 * @author liangyq 2017/12/26
 */
public class MyBeanFactory implements ObjectFactory {

    @Override
    public Object getObjectInstance(Object obj, Name name2, Context nameCtx, Hashtable environment)
            throws NamingException {

        // Acquire an instance of our specified bean class
        MyBean bean = new MyBean();

        // Customize the bean properties from our attributes
        Reference ref = (Reference) obj;
        Enumeration addrs = ref.getAll();
        while (addrs.hasMoreElements()) {
            RefAddr addr = (RefAddr) addrs.nextElement();
            String name = addr.getType();
            String value = (String) addr.getContent();
            if (name.equals("foo")) {
                bean.setFoo(value);
            } else if (name.equals("bar")) {
                try {
                    bean.setBar(Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    throw new NamingException("Invalid 'bar' value " + value);
                }
            }
        }

        // Return the customized instance
        return (bean);
    }

}
