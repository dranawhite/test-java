package com.dranawhite.mybatis.handler;

import com.alibaba.fastjson.JSON;
import com.dranawhite.mybatis.model.Address;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 自定义Mybatis映射处理器，用于处理地址JSON格式的映射
 * <pre>
 * 步骤如下：
 *      1）在mybatis-config.xml中配置<typeHandler/>标签
 *      2）自定义类实现TypeHandler接口
 *      3）标注@MappedTypes注解，用于标识那些Java类型被拦截
 *      4）标注@MappedJdbcTypes注解，用于标识JdbcType类型
 *      5）去mapper.xml中标识那些参数需要用到TypeHandler
 * </pre>
 *
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
@MappedTypes({Address.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class AddressJsonHandler implements TypeHandler<Address> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Address parameter, JdbcType jdbcType)
            throws SQLException {
        String address = JSON.toJSONString(parameter);
        ps.setString(i, address);
    }

    @Override
    public Address getResult(ResultSet rs, String columnName) throws SQLException {
        String address = rs.getString(columnName);
        return JSON.parseObject(address, Address.class);
    }

    @Override
    public Address getResult(ResultSet rs, int columnIndex) throws SQLException {
        String address = rs.getString(columnIndex);
        return JSON.parseObject(address, Address.class);
    }

    @Override
    public Address getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String address = cs.getString(columnIndex);
        return JSON.parseObject(address, Address.class);
    }
}
