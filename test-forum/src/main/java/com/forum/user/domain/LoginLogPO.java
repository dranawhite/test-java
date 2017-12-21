package com.forum.user.domain;

import java.util.Date;

/**
 * 登录日志
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class LoginLogPO extends BaseDomain {

    private static final long serialVersionUID = -2044912558232703083L;

    /**
     * 登录日志ID
     */
    private int loginLogId;

    /**
     * 用户ID
     */
    private int userId;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 登录时间
     */
    private Date loginTime;

    /**
     * @return the loginLogId
     */
    public int getLoginLogId() {
        return loginLogId;
    }

    /**
     * @param loginLogId the loginLogId to set
     */
    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * @param ip the ip to set
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * @return the loginTime
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * @param loginTime the loginTime to set
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
