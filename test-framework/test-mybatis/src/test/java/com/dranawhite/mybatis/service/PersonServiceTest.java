package com.dranawhite.mybatis.service;

import com.dranawhite.mybatis.common.DbHelper;
import com.dranawhite.mybatis.dao.PersonPOMapper;
import com.dranawhite.mybatis.model.PersonPO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author dranawhite 2017/9/30
 * @version 1.0
 */
public class PersonServiceTest {

    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private PersonPOMapper personPOMapper;

    @BeforeClass
    public static void init() {
        sqlSessionFactory = DbHelper.getSessionFactory();
    }

    @Before
    public void initSession() {
        session = sqlSessionFactory.openSession();
        personPOMapper = session.getMapper(PersonPOMapper.class);
    }

    @Test
    public void testPersonInsert() {
        PersonPO person = new PersonPO();
        person.setId(1001);
        person.setAge(26);
        person.setName("hali");
        person.setPhone("15895886124");
        person.setAddress("南京市雨花区大数据产业基地180号");
        personPOMapper.insertPerson(person);
    }

    @After
    public void destroySession() {
        session.commit();
        session.close();
    }

}
