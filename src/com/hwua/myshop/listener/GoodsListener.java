package com.hwua.myshop.listener;

import com.hwua.myshop.biz.GoodsBiz;
import com.hwua.myshop.biz.impl.GoodsBizImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;

@WebListener
public class GoodsListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        GoodsBiz goodsBiz = new GoodsBizImpl();
        List<Map<String, Object>> goods1 = goodsBiz.get1();
        List<Map<String, Object>> goods2 = goodsBiz.get2();
        List<Map<String, Object>> goods3 = goodsBiz.get3();
        servletContext.setAttribute("good1",goods1);
        servletContext.setAttribute("good2",goods2);
        servletContext.setAttribute("good3",goods3);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
