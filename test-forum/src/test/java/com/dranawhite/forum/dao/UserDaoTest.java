package com.dranawhite.forum.dao;

import com.dranawhite.forum.domain.UserPO;
import org.junit.Assert;
import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBeanByType;

public class UserDaoTest extends BaseDaoTest {

	@SpringBeanByType
	private UserMapper userMapper;

	@Test
    @DataSet("data/User.xlsx")
	public void testQueryUserById() {
		UserPO userExist = userMapper.queryUserById(1001);
        Assert.assertNotNull(userExist);
        UserPO userNotExist = userMapper.queryUserById(1004);
        Assert.assertNull(userNotExist);
	}

}
