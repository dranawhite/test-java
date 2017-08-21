package com.dranawhite.logging.log4j1;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public class Log4j1Logger {

    private static final Logger logger = LogManager.getLogger(Log4j1Logger.class);

    public void info() {
        logger.info("日志-Log4j1");
    }

    public void debug() {
        logger.debug("日志-Log4j1");
    }

    public void warn() {
        logger.warn("日志-Log4j1");
    }
}
