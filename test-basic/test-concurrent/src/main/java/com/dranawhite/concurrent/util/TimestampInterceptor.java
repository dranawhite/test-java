package com.dranawhite.concurrent.util;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author dranawhite 2017/9/22
 * @version 1.0
 */
public class TimestampInterceptor implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy)
            throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = methodProxy.invokeSuper(o, objects);
        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;
        System.out.println("耗时：" + time + "ms");
        return result;
    }
}
