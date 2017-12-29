package com.dranawhite.forum.user.domain;

import com.dranawhite.forum.base.BaseDomain;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author dranawhite
 * @version 1.0.0
 */
public class BoardManagerPO extends BaseDomain {

    private static final long serialVersionUID = 2502735575503759564L;

    private Integer boardId;

    private Integer userId;

    public Integer getBoardId() {
        return boardId;
    }

    public void setBoardId(Integer boardId) {
        this.boardId = boardId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}