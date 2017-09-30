package com.dranawhite.mybatis.common;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author dranawhite 2017/9/30
 * @version 1.0
 */
public class DbHelper {

    public static SqlSessionFactory getSessionFactory() {
        Reader reader;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            //若忽略了environment参数，将加载默认的环境
            return new SqlSessionFactoryBuilder().build(reader);
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            return null;
        }
    }

}
