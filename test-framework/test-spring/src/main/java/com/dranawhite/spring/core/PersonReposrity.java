package com.dranawhite.spring.core;

import java.sql.SQLException;

/**
 * @author liangyq
 * @version [1.0, 2018/4/21 11:54]
 */
@ReposrityBusiness
public class PersonReposrity {

	public void printSql() throws SQLException {
		throw new SQLException("SQL异常");
	}

}
