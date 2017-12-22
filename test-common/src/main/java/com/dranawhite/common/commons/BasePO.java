package com.dranawhite.common.commons;

/**
 * @author dranawhite 2017/12/22
 * @version 1.0
 */
public class BasePO {

    protected Integer id;

    protected String desc;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
