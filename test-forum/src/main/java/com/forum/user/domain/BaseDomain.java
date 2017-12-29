package com.forum.user.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.io.Serializable;

/**
 * PO基类
 *
 * @author dranawhite 2017/12/21
 * @version 1.0
 */
public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = -3619438393213553970L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
