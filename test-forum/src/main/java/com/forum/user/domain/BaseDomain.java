package com.forum.user.domain;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import java.io.Serializable;

/**
 * @author dranawhite 2017/12/21
 * @version 1.0
 */
public abstract class BaseDomain implements Serializable {

    private static final long serialVersionUID = -3619438393213553970L;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
