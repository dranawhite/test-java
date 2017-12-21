package com.dranawhite.web.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * @author dranawhite 2017/12/20
 * @version 1.0
 */
@WebServlet("/jdbcServlet")
public class JdbcPro extends HttpServlet {

    private Connection getConnection() throws NamingException, SQLException {
        Context ctx = new InitialContext();
        Context envContext = (Context) ctx.lookup("java:comp/env");
        DataSource dataSource = (DataSource) envContext.lookup("jndi/merchandisecenter");
        return dataSource.getConnection();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            Connection conn = getConnection();
            DatabaseMetaData metaData = conn.getMetaData();
            //MetaData中保存了数据库的元数据信息
            System.out.println(metaData.getDefaultTransactionIsolation());
        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
