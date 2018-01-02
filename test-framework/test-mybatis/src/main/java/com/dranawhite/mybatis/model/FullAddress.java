package com.dranawhite.mybatis.model;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
public class FullAddress extends Address {

    private String province;

    private String area;

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }
}
