package com.dranawhite.forum.service;

import com.dranawhite.forum.dao.UserMapper;
import com.dranawhite.forum.domain.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author dranawhite 2018/1/5
 * @version 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public UserPO getUserInfo(int userId) {
        return userMapper.queryUserById(userId);
    }

}
