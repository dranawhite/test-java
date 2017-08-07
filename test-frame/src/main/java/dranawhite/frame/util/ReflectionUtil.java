package dranawhite.frame.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射工具类
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public class ReflectionUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionUtil.class);

    /**
     * 创建实例
     * @param cls 类
     * @return 实例化对象
     */
    public static Object newInstance(Class<?> cls) {
        Object instance;
        try {
            instance = cls.newInstance();
        } catch (Exception e) {
            LOGGER.error("FRAME-new instance failure", e);
            throw new RuntimeException(e);
        }
        return instance;
    }

    /**
     * 调用方法
     * @param obj 对象
     * @param method 方法
     * @param args 参数
     * @return 执行方法返回结果
     */
    public static Object invokeMethod(Object obj, Method method, Object ...args) {
        Object result;
        try {
            method.setAccessible(true);
            result = method.invoke(obj, args);
        } catch (Exception e) {
            LOGGER.error("FRAME-invoke method failure", e);
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * 设置成员变量的值
     * @param obj 对象
     * @param field 字段
     * @param value 值
     */
    public static void setFiled(Object obj, Field field, Object value) {
        try {
            field.setAccessible(true);
            field.set(obj, value);
        } catch(Exception e) {
            LOGGER.error("FRAME-set field failure", e);
            throw new RuntimeException(e);
        }
    }
}
