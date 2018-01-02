package com.dranawhite.mybatis.service;

import com.dranawhite.mybatis.common.DbHelper;
import com.dranawhite.mybatis.dao.PersonMapper;
import com.dranawhite.mybatis.model.Address;
import com.dranawhite.mybatis.model.PersonPO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * @author dranawhite 2017/9/30
 * @version 1.0
 */
public class PersonServiceTest {

    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession session;
    private PersonMapper personMapper;

    @BeforeClass
    public static void init() {
        sqlSessionFactory = DbHelper.getSessionFactory();
    }

    @Before
    public void initSession() {
        session = sqlSessionFactory.openSession();
        personMapper = session.getMapper(PersonMapper.class);
    }

    @Test
    public void testPersonInsert() {
        PersonPO person = new PersonPO();
        person.setId(1001);
        person.setAge(26);
        person.setName("hali");
        person.setPhone("15895886124");
        Address address = new Address();
        address.setAddress("南京市雨花区大数据产业基地");
        address.setNo(180);
        person.setAddress(address);
        personMapper.insertPerson(person);
    }

    @Test
    public void testPersonQuery() {
        PersonPO pn = new PersonPO();
        pn.setId(1001);
        pn.setName("ha");
        List<PersonPO> poList = personMapper.queryPersons(pn);
        System.out.println(poList);
    }

    @After
    public void destroySession() {
        session.commit();
        session.close();
    }

}
