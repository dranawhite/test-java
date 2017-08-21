package com.dranawhite.logging.jdk;

import org.junit.Test;

import java.io.IOException;

/**
 * @author dranawhite 2017/8/21
 * @version 1.0
 */
public class JdkLoggerTest {

    @Test
    public void testInfo() throws IOException {
        JdkLogger logger = new JdkLogger();
        logger.info();
    }

}
