/**
 * <pre>
 *     声明自定义的资源工厂处理JNDI资源
 * 1）在web.xml中声明JNDI
 *    <resource-env-ref>
 *      <description>MyBean实例的ObjectFactory</description>
 *      <resource-env-ref-name>bean/MyBeanFactory</resource-env-ref-name>
 *      <resource-env-ref-type>com.dranawhite.catalina.jndi.MyBean</resource-env-ref-type>
 *    </resource-env-ref>
 * 2）在<context>中配置资源工厂
 *      <Resource auth="Container"
 *          factory="org.apache.naming.factory.BeanFactory"
 *          name="bean/MyBeanFactory"
 *          type="com.dranawhite.catalina.jndi.MyBean" />
 * 3）使用资源
 *      Context initCtx = new InitialContext();
 *      Context envCtx = (Context) initCtx.lookup("java:comp/env");
 *      DataSource ds = (DataSource)
 *      envCtx.lookup("jdbc/EmployeeDB");

 *      Connection conn = ds.getConnection();
 *      ... use this connection to access the database ...
 *      conn.close();
 * 4）资源工厂实现javax.naming.spi.ObjectFactory接口
 * </pre>
 *
 * @author liangyq 2017/12/26
 */

package com.dranawhite.web.jndi;