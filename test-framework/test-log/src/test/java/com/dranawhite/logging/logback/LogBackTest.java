package com.dranawhite.logging.logback;

import org.junit.Test;

/**
 * @author dranawhite 2017/9/18
 * @version 1.0
 */
public class LogBackTest {

    private static final LogBackLogger logger = new LogBackLogger();

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
