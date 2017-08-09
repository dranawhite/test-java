package com.dranawhite.frame;

import com.dranawhite.frame.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Bean助手类
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public final class BeanHelper {

    private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
        for (Class<?> beanClass : beanClassSet) {
            Object obj = ReflectionUtil.newInstance(beanClass);
            BEAN_MAP.put(beanClass, obj);
        }
    }

    /**
     * 获取Bean映射
     * @return Map
     */
    public static Map<Class<?>, Object> getBeanMap() {
        return BEAN_MAP;
    }

    public static <T> T getBean(Class<T> cls) {
        if (!BEAN_MAP.containsKey(cls)) {
            throw new RuntimeException("FRAME-can not get bean by class: " + cls);
        }
        return (T) BEAN_MAP.get(cls);
    }

}
