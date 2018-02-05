package com.hwua.myshop.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

public class JDBCDataSource {

    private static DataSource dataSource;

    static {
        init();
    }

    private JDBCDataSource(){}

    public static DataSource getDataSource() {
        return dataSource;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void init() {
        Map<String, Object> params = new HashMap<>();
        params.put(DruidDataSourceFactory.PROP_DRIVERCLASSNAME, JDBCConfig.getProperty("jdbc.driver"));
        params.put(DruidDataSourceFactory.PROP_URL, JDBCConfig.getProperty("jdbc.url"));
        params.put(DruidDataSourceFactory.PROP_USERNAME, JDBCConfig.getProperty("jdbc.username"));
        params.put(DruidDataSourceFactory.PROP_PASSWORD, JDBCConfig.getProperty("jdbc.password"));
        try {
            dataSource = DruidDataSourceFactory.createDataSource(params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}