package com.dranawhite.forum.controller;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author dranawhite 2018/1/5
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({ "classpath:spring/spring-mvc.xml",
        "classpath:spring/spring-context.xml", "classpath:spring/spring-datasource.xml"})
@Transactional
@Rollback
public abstract class BaseControllerTest {

}
