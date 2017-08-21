package com.dranawhite.logging.log4j1;

import org.junit.Test;

/**
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public class Log4j1LoggerTest {

    private static final Log4j1Logger logger = new Log4j1Logger();


    @Test
    public void testInfo() {
        logger.info();
    }

    @Test
    public void testDebug() {
        logger.debug();
    }

    @Test
    public void testWarn() {
        logger.warn();
    }

}
