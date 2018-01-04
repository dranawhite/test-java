package com.dranawhite.forum.dao;

import com.dranawhite.forum.domain.UserPO;
import com.dranawhite.forum.util.XlsDataSetBeanFactory;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

import java.util.List;

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

    @Test
    @ExpectedDataSet("data/ExceptedUser.xlsx")
    public void testInsertUser() throws Exception {
        Resource resource = new ClassPathResource("data/ExceptedUser.xlsx");
        List<UserPO> userList =
                XlsDataSetBeanFactory.createBeans(resource.getFile(), "T_USER", UserPO.class);
        for (UserPO user : userList) {
            userMapper.insertUser(user);
        }

    }
}
