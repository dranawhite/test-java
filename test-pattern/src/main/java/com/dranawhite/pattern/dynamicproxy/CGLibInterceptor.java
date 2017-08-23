package com.dranawhite.pattern.dynamicproxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * CGLib字节码生成
 * <pre>
 *     对代理类所有方法的调用都会调用CGLibInterceptor，
 * 该类执行intercept()方法对方法进行拦截.
 *     被代理类无需实现任何接口
 * </pre>
 *
 * @author dranawhite 2017/8/16
 * @version 1.0
 */
class CGLibInterceptor implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        //CGLib中的加强器，用来创建动态代理
        return (T) Enhancer.create(cls, this);
    }

    public void beforeSay() {
        System.out.println("闪开，我要开始装逼了！");
    }

    public void afterSay() {
        System.out.println("装完逼就跑，真刺激！");
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        beforeSay();
        Object result = methodProxy.invokeSuper(obj, args);
        afterSay();
        return result;
    }
}
