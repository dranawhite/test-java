package com.forum.user.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class UserPO implements Serializable {

    private static final long serialVersionUID = -5283841760973297794L;
    /**
     * 用户ID
     */
    private int userId;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 积分
     */
    private int credits;

    /**
     * 密码
     */
    private String password;

    /**
     * 最近访问时间
     */
    private Date lastVisit;

    /**
     * 最近访问IP
     */
    private String lastIp;

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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the credits
     */
    public int getCredits() {
        return credits;
    }

    /**
     * @param credits the credits to set
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the lastVisit
     */
    public Date getLastVisit() {
        return lastVisit;
    }

    /**
     * @param lastVisit the lastVisit to set
     */
    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    /**
     * @return the lastIp
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * @param lastIp the lastIp to set
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Override
    public String toString() {
        return "UserPO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", credits=" + credits +
                ", password='" + password + '\'' +
                ", lastVisit=" + lastVisit +
                ", lastIp='" + lastIp + '\'' +
                '}';
    }
}
