package dranawhite.frame;

import dranawhite.frame.util.ClassUtil;

/**
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class,
                ControllerHelper.class};
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(), false);
        }
    }

}
