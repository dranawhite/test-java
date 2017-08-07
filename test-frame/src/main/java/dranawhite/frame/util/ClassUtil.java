package dranawhite.frame.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 类工具
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public class ClassUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassUtil.class);

    /**
     * 获取类加载器
     * @return ClassLoader
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 加载类
     * @param className 类名
     * @param isInitialized 是否初始化
     * @return Class
     */
    public static Class<?> loadClass(String className, boolean isInitialized) {
        Class<?> cls;
        try {
            cls = Class.forName(className, isInitialized, getClassLoader());
        } catch(ClassNotFoundException cnfe) {
            LOGGER.error("FRAME-load class failure!", cnfe);
            throw new RuntimeException(cnfe);
        }
        return cls;
    }

    /**
     * 获取指定包名下的所有类
     * @param pkgName 包名
     * @return class集
     */
    public static Set<Class<?>> getClassSet(String pkgName) {
        Set<Class<?>> clsSet = new HashSet<>();
        try {
            Enumeration<URL> urls = getClassLoader().getResources(pkgName.replace(".", "/"));
            while(urls.hasMoreElements()) {
                URL url = urls.nextElement();
                if (url == null) {
                    return clsSet;
                }
                String protocol = url.getProtocol();
                if (protocol.equals("file")) {
                    String packagePath = url.getPath().replaceAll("%20", " ");
                    addClass(clsSet, packagePath, pkgName);
                } else if (protocol.equals("jar")) {
                    JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                    if (jarURLConnection != null) {
                        JarFile jarFile = jarURLConnection.getJarFile();
                        if (jarFile != null) {
                            Enumeration<JarEntry> jarEntries = jarFile.entries();
                            while (jarEntries.hasMoreElements()) {
                                JarEntry jarEntry = jarEntries.nextElement();
                                String jarEntryName = jarEntry.getName();
                                if (jarEntryName.endsWith(".classes")) {
                                    String className = jarEntryName.substring(0, jarEntryName
                                            .lastIndexOf(".")).replaceAll("/", ".");
                                    doAddClass(clsSet, className);
                                }
                            }
                        }
                    }
                }
            }
        } catch (IOException ioe) {
            LOGGER.error("FRAME-get class set failure", ioe);
            throw new RuntimeException(ioe);
        }
        return clsSet;
    }

    private static void addClass(Set<Class<?>> classSet, String pkgPath, String pkgName) {
        File[] files = new File(pkgPath).listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return (pathname.isFile() && pathname.getName().endsWith(".class") || pathname.isDirectory());
            }
        });
        for (File file : files) {
            String fileName = file.getName();
            if(file.isFile()) {
                String className = fileName.substring(0, fileName.lastIndexOf("."));
                if (StringUtils.isNotEmpty(pkgName)) {
                    className = pkgName + "." + className;
                }
                doAddClass(classSet, className);
            } else {
                String subPackagePath = fileName;
                if(StringUtils.isNotEmpty(pkgPath)) {
                    subPackagePath = pkgPath + "/" + subPackagePath;
                }
                String subPackageName = fileName;
                if (StringUtils.isNotEmpty(pkgName)) {
                    subPackageName = pkgName + "." + subPackageName;
                }
                addClass(classSet, subPackagePath, subPackageName);
            }
        }
    }

    private static void doAddClass(Set<Class<?>> classSet, String clsName) {
        Class<?> cls = loadClass(clsName, false);
        classSet.add(cls);
    }

}
