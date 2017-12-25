package com.dranawhite.web.jndi;

import java.util.Enumeration;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.Name;
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

    /**
     * @param reference   The (possibly null) object containing location or reference
     *                    information that
     *                    can be used in creating an object. For Tomcat, this will always be an object
     *                    of type javax.naming.Reference, which contains the class name of this factory
     *                    class, as well as the configuration properties (from the <Context> for the
     *                    web application) to use in creating objects to be returned.
     * @param name        The name to which this factory is bound relative to nameCtx, or null if no name is specified.
     * @param nameCtx     The context relative to which the name parameter is specified, or null if name
     *                    is relative to the default initial context.
     * @param environment The (possibly null) environment that is used in creating this object. This
     *                    is generally ignored in Tomcat object factories.
     *
     * @return
     */
    @Override
    public Object getObjectInstance(Object reference, Name name, Context nameCtx, Hashtable
            environment) {
        // Acquire an instance of our specified bean class
        MyBean bean = new MyBean();

        // Customize the bean properties from our attributes
        Reference ref = (Reference) reference;
        Enumeration addrs = ref.getAll();
        while (addrs.hasMoreElements()) {
            //RefAddr中包含了在<context>中配置的所有属性
            RefAddr addr = (RefAddr) addrs.nextElement();
            String propName = addr.getType();
            String propValue = (String) addr.getContent();
            if (propName.equals("foo")) {
                bean.setFoo(propValue);
            } else if (propName.equals("bar")) {
                bean.setBar(Integer.parseInt(propValue));
            }
        }
        // Return the customized instance
        return (bean);
    }

}
