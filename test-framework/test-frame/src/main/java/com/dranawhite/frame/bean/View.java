package com.dranawhite.frame.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * 视图对象
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public class View {

    /**
     * 视图路径
     */
    private String path;

    /**
     * 模型数据
     */
    private Map<String, Object> model;

    public View(String path) {
        this.path = path;
        this.model = new HashMap<>();
    }

    public View addModel(String key, Object value) {
        model.put(key, value);
        return this;
    }

    public String getPath() {
        return this.path;
    }

    public Map<String, Object> getModel() {
        return model;
    }
}
