package com.forum.user.dao;

import com.forum.user.domain.LoginLogPO;
import com.forum.user.domain.UserPO;
import org.springframework.stereotype.Repository;

/**
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
@Repository
public interface IUserDao {

    /**
     * 根据用户名和密码匹配用户
     *
     * @param user 用户信息
     *
     * @return 匹配成功，返回true；匹配失败，返回false
     */
    boolean isUserMatch(UserPO user);

    /**
     * 根据用户名获取User对象
     *
     * @param userName 用户名
     *
     * @return UserPO
     */
    UserPO queryByName(String userName);

    /**
     * 更新登录信息
     *
     * @param loginLog 登录信息
     */
    void updateLoginInfo(LoginLogPO loginLog);
}
