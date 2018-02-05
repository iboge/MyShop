package com.hwua.myshop.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JDBCConfig {

    private static Properties properties;

    static {
        init();
    }

    private JDBCConfig(){}

    /**
     * 提供Properties对象的方法，对象设置为单例模式
     * @return
     */
    public static Properties getProperties() {
        return properties;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    //初始化方法
    private static void init() {
        InputStream is = null;
        try {
            //获取配置文件jdbc.proterties
//            is = this.getClass().getResourceAsStream("jdbc.properties");
            is = JDBCConfig.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //创建Properties对象
            properties = new Properties();
            //Properties对象加载输入流
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                //归还
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}