package com.zte.sunquan.demo.pg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayDeque;
import java.util.Properties;
import java.util.Stack;

import org.junit.Test;
import org.postgresql.Driver;

/**
 * Created by 10184538 on 2018/4/24.
 */
public class PGTest {
    @Test
    public void dbTest() throws SQLException {
//        String url = "jdbc:postgresql://localhost:5432/test";
        String url = "jdbc:postgresql://localhost:5432/dsbenchmark";
        Properties props = new Properties();
        props.setProperty("user", "sunquan");
        props.setProperty("password", "1");
        DriverManager.registerDriver(new Driver());
        Connection connection =
                DriverManager.getConnection(url, props);
        System.out.println(connection);
        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select * from emp");
        ResultSet resultSet = statement.executeQuery("select * from test2");
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
            System.out.println(resultSet.getString(3));
            System.out.println(resultSet.getString(2));
            System.out.println("****************************");
        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}
