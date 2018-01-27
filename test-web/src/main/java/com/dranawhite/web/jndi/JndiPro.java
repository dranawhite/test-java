package com.dranawhite.web.jndi;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    private MyBean getBeanByJndi() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context) ctx.lookup("java:comp/env");
            MyBean bean = (MyBean) envContext.lookup("bean/MyBeanFactory");
            return bean;
        } catch (NamingException ne) {
            ne.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        MyBean bean = getBeanByJndi();
        System.out.println(bean.toString());
    }
}
