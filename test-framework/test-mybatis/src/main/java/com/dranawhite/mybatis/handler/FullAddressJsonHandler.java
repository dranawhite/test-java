package com.dranawhite.mybatis.handler;

import com.alibaba.fastjson.JSON;
import com.dranawhite.mybatis.model.Address;
import com.dranawhite.mybatis.model.FullAddress;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author dranawhite 2018/1/2
 * @version 1.0
 */
@MappedTypes(FullAddress.class)
@MappedJdbcTypes(JdbcType.VARCHAR)
public class FullAddressJsonHandler implements TypeHandler<FullAddress> {

    @Override
    public void setParameter(PreparedStatement ps, int i, FullAddress parameter, JdbcType jdbcType)
            throws SQLException {
        String address = JSON.toJSONString(parameter);
        ps.setString(i, address);
    }

    @Override
    public FullAddress getResult(ResultSet rs, String columnName) throws SQLException {
        String address = rs.getString(columnName);
        return JSON.parseObject(address, FullAddress.class);
    }

    @Override
    public FullAddress getResult(ResultSet rs, int columnIndex) throws SQLException {
        String address = rs.getString(columnIndex);
        return JSON.parseObject(address, FullAddress.class);
    }

    @Override
    public FullAddress getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String address = cs.getString(columnIndex);
        return JSON.parseObject(address, FullAddress.class);
    }
}
