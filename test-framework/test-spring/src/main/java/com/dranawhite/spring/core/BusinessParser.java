package com.dranawhite.spring.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author liangyq
 * @version [1.0, 2018/4/21 11:50]
 */
public class BusinessParser {

	public static void main(String[] args) throws SQLException {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("core/applicationContext-core-scan" +
				".xml");
		PersonBusiness personBusiness = ctx.getBean(PersonBusiness.class);
		personBusiness.print();

		PersonReposrity personReposrity = ctx.getBean(PersonReposrity.class);
		personReposrity.printSql();
	}

}
