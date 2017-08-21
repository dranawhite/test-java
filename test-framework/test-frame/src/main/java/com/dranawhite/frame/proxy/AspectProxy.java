package com.dranawhite.frame.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * 切面代理
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public abstract class AspectProxy implements Proxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    @Override
    public final Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] params = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(cls, method, params)) {
                before(cls, method, params);
                result = proxyChain.doProxyChain();
                after(cls, method, params, result);
            } else {
                result = proxyChain.doProxyChain();
            }
        } catch (Exception e) {
            LOGGER.error("代理失败！", e);
            error(cls, method, params, e);
            throw e;
        } finally {
            end();
        }
        return result;
    }

    public abstract void begin();

    public abstract boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable;

    public abstract void before(Class<?> cls, Method method, Object[] params) throws Throwable;

    public abstract void after(Class<?> cls, Method method, Object[] params, Object result)
            throws Throwable;

    public abstract void error(Class<?> cls, Method method, Object[] params, Throwable e);

    public abstract void end();
}
