package com.dranawhite.frame;

import com.dranawhite.frame.util.ClassUtil;

/**
 * 加载器助手
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = { ClassHelper.class, BeanHelper.class, AopHelper.class,
                IocHelper.class, ControllerHelper.class };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), true);
        }
    }

}
