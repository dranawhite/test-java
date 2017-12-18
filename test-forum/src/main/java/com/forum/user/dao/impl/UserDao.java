package com.forum.user.dao.impl;

import com.forum.user.dao.IUserDao;
import com.forum.user.domain.LoginLogPO;
import com.forum.user.domain.UserPO;

/**
 * @author dranawhite 2017/12/18
 * @version 1.0
 */
public class UserDao implements IUserDao {

    @Override
    public boolean isUserMatch(UserPO user) {
        return false;
    }

    @Override
    public UserPO queryByName(String userName) {
        return null;
    }

    @Override
    public void updateLoginInfo(LoginLogPO loginLog) {

    }
}
