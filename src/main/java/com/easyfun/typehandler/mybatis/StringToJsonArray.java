package com.easyfun.typehandler.mybatis;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.util.Assert;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author     ：李冠良
 * @description： 无描述
 * @date       ：2024/11/18 下午4:48
 */

public class StringToJsonArray extends BaseTypeHandler<JsonArray> {

    private final Gson gson;

    public StringToJsonArray(Gson gson) {
        Assert.notNull(gson, "gson cannot be null");
        this.gson = gson;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, JsonArray parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, gson.toJson(parameter));
    }

    @Override
    public JsonArray getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String jsonStr = rs.getString(columnName);
        return gson.fromJson(jsonStr, JsonArray.class);
    }

    @Override
    public JsonArray getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String jsonStr = rs.getString(columnIndex);
        return gson.fromJson(jsonStr, JsonArray.class);
    }

    @Override
    public JsonArray getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String jsonStr = cs.getString(columnIndex);
        return gson.fromJson(jsonStr, JsonArray.class);
    }
}