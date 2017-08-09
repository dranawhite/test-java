package com.dranawhite.frame.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public final class StreamUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(StreamUtil.class);

    /**
     * 从输入流中获取字符串
     * @param ins 输入流
     * @return
     */
    public static String getString(InputStream ins) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ins));
            String line;
            while((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch(Exception e) {
            LOGGER.error("FRAME-get string failure", e);
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

}
