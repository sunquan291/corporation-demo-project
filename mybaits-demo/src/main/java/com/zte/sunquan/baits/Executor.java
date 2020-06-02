package com.zte.sunquan.baits;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Author: Livio
 * @Date: 2020/6/1 23:00
 */
public class Executor {
    private Connection connection;

    public <T> T query(String sql, Class<T> cls, Object[] params) {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/oscp_test?serverTimezone=UTC", "root", "root");
            Statement statement = connection.createStatement();
            String execSql = String.format(sql, params);
            ResultSet resultSet = statement.executeQuery(execSql);
            T result = cls.newInstance();
            Map<String, Field> fields = new HashMap<>();
            for (Field field : cls.getDeclaredFields()) {
                String fieldName = field.getName();
                field.setAccessible(true);
                fields.put(fieldName, field);
            }
            while (resultSet.next()) {
                Set<Map.Entry<String, Field>> entries = fields.entrySet();
                for (Map.Entry<String, Field> entry : entries) {
                    String key = entry.getKey();
                    System.out.println(key);
                    if (entry.getValue().getType() == String.class) {
                        entry.getValue().set(result, resultSet.getString(key));
                    } else if (entry.getValue().getType() == Long.class) {
                        entry.getValue().set(result, resultSet.getLong(key));
                    } else if (entry.getValue().getType() == int.class) {
                        entry.getValue().set(result, resultSet.getInt(key));
                    }
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }
}
