package com.dranawhite.mybatis.service;

import com.dranawhite.mybatis.common.DbHelper;
import com.dranawhite.mybatis.dao.PersonMapper;
import com.dranawhite.mybatis.model.Address;
import com.dranawhite.mybatis.model.FullAddress;
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
        PersonPO person1 = new PersonPO();
        person1.setId(1001);
        person1.setAge(26);
        person1.setName("hali");
        person1.setPhone("15895886124");
        Address address1 = new Address();
        address1.setAddress("南京市雨花区大数据产业基地");
        address1.setNo(180);
        person1.setAddress(address1);
        person1.setAddressType(1);
        personMapper.insertPerson(person1);

        PersonPO person2 = new PersonPO();
        person2.setId(1001);
        person2.setAge(26);
        person2.setName("hali");
        person2.setPhone("15895886124");
        FullAddress address2 = new FullAddress();
        address2.setProvince("江苏省");
        address2.setArea("南京市");
        address2.setAddress("雨花区大数据产业基地");
        address2.setNo(180);
        person2.setAddress(address2);
        person2.setAddressType(2);
        personMapper.insertPerson(person2);
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
