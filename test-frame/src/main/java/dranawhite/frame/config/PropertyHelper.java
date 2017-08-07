package dranawhite.frame.config;

import dranawhite.frame.util.PropsUtil;

import java.util.Properties;

/**
 * Property文件助手类
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public final class PropertyHelper {

    private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.PROPERTY_FILE);

    /**
     * 获取JDBC驱动
     * @return JDBC驱动字符串
     */
    public static String getJdbcDriver() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     * @return JDBC URL字符串
     */
    public static String getJdbcUrl() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC用户
     * @return JDBC用户字符串
     */
    public static String getJdbcUser() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USER);
    }

    /**
     * 获取JDBC密码
     * @return JDBC密码字符串
     */
    public static String getJdbcPass() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取APP基础包名
     * @return 包名
     */
    public static String getAppBasePackage() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取APP JSP路径
     * @return JSP路径
     */
    public static String getAppJspPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH);
    }

    /**
     * 获取APP静态资源路径
     * @return 静态资源路径
     */
    public static String getAppAssetPath() {
        return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH);
    }

}
