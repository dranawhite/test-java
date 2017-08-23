package com.dranawhite.logging.jdk;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <pre>
 *     日志管理器：默认是java.util.logging.LogManager，也可以通过修改系统属性"java.util.logging.manager"自定义
 *     配置文件：默认是jre目录下的lib/logging.properties，也可以自定义修改系统属性"java.util.logging.config.file"
 * </pre>
 *
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
class JdkLogger {

    public void info() throws IOException {
        Logger logger = Logger.getLogger("logging.jdk");
        logger.setLevel(Level.INFO);
        //指定输出路径，如果不指定路径日志文件将位于项目根路径下;默认是打印到控制台
        FileHandler fileHandler = new FileHandler("log/jdk.log");
        fileHandler.setLevel(Level.ALL);
        fileHandler.setFormatter(new JdkLogFormatter());
        logger.addHandler(fileHandler);
        logger.info("JDK自带日志");
    }

}

