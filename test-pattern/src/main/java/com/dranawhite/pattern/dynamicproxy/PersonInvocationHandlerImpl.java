package com.dranawhite.pattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理的类必须要实现一个接口
 *
 * @author dranawhite 2017/8/9
 * @version 1.0
 */
class PersonInvocationHandlerImpl implements InvocationHandler {

    private IPerson person;

    public PersonInvocationHandlerImpl() {
        this.person = new Person();
    }

    public void beforeSay() {
        System.out.println("闪开，我要开始装逼了！");
    }

    public void afterSay() {
        System.out.println("装完逼就跑，真刺激！");
    }

    /**
     * <pre>
     * 创建代理对象 在这个过程中，
     *      a.JDK会通过根据传入的参数信息动态地在内存中创建和.class 文件等同的字节码
     *      b.然后根据相应的字节码转换成对应的class，
     *      c.然后调用newInstance()创建实例
     * </pre>
     *
     * @return
     */
    public IPerson getPersonProxy() {
        return (IPerson) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), new
                        Class[]{IPerson.class}, this );
    }

    @Override
    public Object invoke(Object personProxy, Method sayMethod, Object[] args) throws Throwable {
        beforeSay();
        Object result = sayMethod.invoke(person, args);
        afterSay();
        return result;
    }
}
