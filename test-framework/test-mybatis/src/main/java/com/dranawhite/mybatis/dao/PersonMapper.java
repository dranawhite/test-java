package com.dranawhite.mybatis.dao;

import com.dranawhite.mybatis.model.PersonPO;

import java.util.List;

/**
 * @author dranawhite
 */
public interface PersonMapper {

    void insertPerson(PersonPO person);

    List<PersonPO> queryPersons(PersonPO person);
}