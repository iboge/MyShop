package com.hwua.myshop.listener;

import com.hwua.myshop.biz.impl.GoodsBizImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;

@WebListener
public class AllGoodsListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        ServletContext servletContext = servletContextEvent.getServletContext();
        GoodsBizImpl goodsBiz = new GoodsBizImpl();
        List<Map<String, Object>> allGoods = goodsBiz.getAllGoods();
        List<Map<String, Object>> allHW = goodsBiz.getAllHW();
        servletContext.setAttribute("allGoods",allGoods);
        servletContext.setAttribute("allHW",allHW);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
