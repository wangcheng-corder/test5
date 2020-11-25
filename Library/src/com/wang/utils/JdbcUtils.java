package com.wang.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//工具类，用户注册jdbc驱动和连接
public class JdbcUtils {
    private static  Properties prop=new Properties();
    static {
        try(InputStream is =
                    JdbcUtils.class.getResourceAsStream("jdbc.properties");
        ){
            prop.load(is);
            Class.forName(prop.getProperty("driver"));
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
    }
}
