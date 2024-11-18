package com.easyfun.typehandler.mybatis;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * @author ：李冠良
 * @description： 无描述
 * @date ：2024/11/18 上午8:41
 */

@Component
public class JsonToList extends BaseTypeHandler<ArrayList<String>>{

    private final Gson gson;

    @Autowired
    public JsonToList(Gson gson) {
        Assert.notNull(gson, "gson cannot be null");
        this.gson = gson;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, ArrayList<String> parameter, JdbcType jdbcType) throws SQLException {
        try {
            ps.setString(i, gson.toJson(parameter));
        } catch (Exception e) {
            throw new SQLException("Error converting to JSON string", e);
        }
    }

    @Override
    public ArrayList<String> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseJson(rs.getString(columnName));
    }

    @Override
    public ArrayList<String> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseJson(rs.getString(columnIndex));
    }

    @Override
    public ArrayList<String> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseJson(cs.getString(columnIndex));
    }

    private ArrayList<String> parseJson(String jsonString) {
        if (jsonString == null || jsonString.isEmpty()) {
            return new ArrayList<>();
        }
        try {
            return gson.fromJson(jsonString, new TypeToken<ArrayList<String>>() {}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Error parsing JSON string to List<String>", e);
        }
    }
}