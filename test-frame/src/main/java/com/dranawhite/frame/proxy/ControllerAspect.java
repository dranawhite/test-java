package com.dranawhite.frame.proxy;

import com.dranawhite.frame.annotation.Aspect;
import com.dranawhite.frame.annotation.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

/**
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

    private static final Logger LOGGER = LoggerFactory.getLogger(ControllerAspect.class);

    private long begin;

    @Override
    public void begin() {

    }

    @Override
    public boolean intercept(Class<?> cls, Method method, Object[] params) throws Throwable {
        return false;
    }

    @Override
    public void before(Class<?> cls, Method method, Object[] params) throws Throwable {
        LOGGER.debug("--------BEGIN--------");
        LOGGER.debug(String.format("class: %s", cls.getName()));
        LOGGER.debug(String.format("method: %s", method.getName()));
        begin = System.currentTimeMillis();
    }

    @Override
    public void after(Class<?> cls, Method method, Object[] params, Object result)
            throws Throwable {
        LOGGER.debug(String.format("time: %dms", System.currentTimeMillis() - begin));
        LOGGER.debug("--------END--------");
    }

    @Override
    public void error(Class<?> cls, Method method, Object[] params, Throwable e) {

    }

    @Override
    public void end() {

    }
}
