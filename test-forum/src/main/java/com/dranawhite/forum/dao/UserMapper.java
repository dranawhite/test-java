package com.dranawhite.forum.dao;

import com.dranawhite.forum.domain.UserPO;
import org.springframework.stereotype.Repository;

/**
 * @author dranawhite
 * @version 1.0.0
 */
@Repository
public interface UserMapper extends BaseDao {

    /**
     * 根据UserId查询用户信息
     *
     * @param userId 用户ID
     *
     * @return 用户信息
     */
    UserPO queryUserById(int userId);

}