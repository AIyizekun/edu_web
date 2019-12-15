package com.dw.handler;

import com.dw.dict.RoleEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author yangjunxiong
 * @date 2018/5/22 16:08
 */
public class RoleEnumHandler extends BaseTypeHandler<RoleEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, RoleEnum item, JdbcType jdbcType) throws SQLException {
        if (item != null) {
            preparedStatement.setInt(i, item.getValue());
        }
    }

    @Override
    public RoleEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return to(resultSet.getObject(s));
    }

    @Override
    public RoleEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return to(resultSet.getObject(i));
    }

    @Override
    public RoleEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return to(callableStatement.getObject(i));
    }

    private RoleEnum to(Object value) {
        if (value == null) {
            return null;
        }

        Integer intVal = (Integer) value;
        return RoleEnum.valueOf(intVal);
    }
}
