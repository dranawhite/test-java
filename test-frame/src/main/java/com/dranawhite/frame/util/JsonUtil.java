package com.dranawhite.frame.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public final class JsonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JsonUtil.class);

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /**
     * 将POJO转为JSON
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJson(T obj) {
        String json;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            LOGGER.error("FRAME-convert POJO to JSON failure", e);
            throw new RuntimeException(e);
        }
        return json;
    }

    public static <T> T fromJson(String json, Class<T> type) {
        T pojo;
        try {
            pojo = OBJECT_MAPPER.readValue(json, type);
        } catch (Exception e) {
            LOGGER.error("FRAME-convert JSON to POJO failure", e);
            throw new RuntimeException(e);
        }
        return pojo;
    }

}
