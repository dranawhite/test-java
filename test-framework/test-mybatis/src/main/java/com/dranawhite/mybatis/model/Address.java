package com.dranawhite.mybatis.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.type.Alias;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
@Alias("Address")
public class Address {

    private String address;

    private int no;

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
