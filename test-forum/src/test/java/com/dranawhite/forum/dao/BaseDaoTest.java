package com.dranawhite.forum.dao;

import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

/**
 * Dao测试基类
 *
 * @author liangyq 2018/1/2
 */
@SpringApplicationContext({"classpath:spring/spring-context.xml",
        "classpath:spring/spring-datasource.xml"})
public abstract class BaseDaoTest extends UnitilsJUnit4 {

}
