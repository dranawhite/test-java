package com.dranawhite.forum.dao;

import static org.junit.Assert.*;

import com.dranawhite.forum.domain.UserPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;


public class UserDaoTest extends BaseDaoTest {

	@Autowired
	private UserMapper userMapper;

	/**
	 * 验证数据库保存的正确性
	 */
	@Test
	@DataSet("User.xls")
	@ExpectedDataSet("ExpectedUser.xls")
	public void testSave() {
		UserPO user = XlsDataSetBeanFactory.createBean(UserDaoTest.class,"User.xls",
                "t_user", UserPO.class);
		userDao.update(u);  //执行用户信息更新操作
	}
	
	//验证数据库保存的正确性
	//@Test
	//@ExpectedDataSet("XiaoChun.ExpectedSaveUsers.xls")// 准备验证数据
	public void saveUsers()throws Exception  {
		List<User> users  = XlsDataSetBeanFactory.createBeans(UserDaoTest.class,"XiaoChun.SaveUsers.xls", "t_user", User.class);
		for(User u:users){
		     userDao.save(u);
		}
	}

}
