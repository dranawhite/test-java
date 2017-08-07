package dranawhite.frame.bean;

import dranawhite.frame.util.CastUtil;

import java.util.Map;

/**
 * 请求参数对象
 *
 * @author dranawhite 2017/8/7
 * @version 1.0
 */
public class Param {

    private Map<String, Object> paramMap;

    public Param(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    /**
     * 根据参数名获取long型参数值
     * @param name 参数名
     * @return 值
     */
    public Long getLong(String name) {
        return CastUtil.castLong(paramMap.get(name));
    }

    /**
     * 获取所有字段信息
     * @return
     */
    public Map<String, Object> getMap() {
        return paramMap;
    }

}
