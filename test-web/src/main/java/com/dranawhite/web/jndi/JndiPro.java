package com.dranawhite.web.jndi;

import java.sql.Connection;
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
 * <pre>
 *     使用JNDI调用服务器资源
 *     输出结果如下：
 *     jdbc:mysql://99.48.58.196:3306/merchandisecenter?useUnicode=true&characterEncoding=utf8,
 *  UserName=merchandise@mime@99.48.58.98, MySQL Connector Java
 * </pre>
 *
 * @author dranawhite 2017/11/3
 * @version 1.0
 */
@WebServlet("/jndiServlet")
public class JndiPro extends HttpServlet {

    private Connection getConnByJndi() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:comp/env");
            DataSource ds = (DataSource) envContext.lookup("jndi/merchandisecenter");
            return ds.getConnection();
        } catch (NamingException ne) {
            ne.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        Connection conn = getConnByJndi();
        System.out.println(conn);
    }
}
