package com.dranawhite.concurrent.serial;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dranawhite 2017/9/25
 * @version 1.0
 */
public class CounterInvocationHandler implements InvocationHandler {

    private Counter counter;

    public CounterInvocationHandler(Counter counter) {
        this.counter = counter;
    }

    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(counter.getClass().getClassLoader(), new
                Class[]{Counter.class}, this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object obj = method.invoke(counter, args);
        long endTime = System.currentTimeMillis();
        System.out.println("耗时：" + (endTime - startTime) + "ms");
        return obj;
    }
}
