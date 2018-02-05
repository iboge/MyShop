package com.hwua.myshop.listener;

import com.hwua.myshop.biz.DriectoryBiz;
import com.hwua.myshop.biz.impl.DriectoryBizImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;

@WebListener
public class DriectoryListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ServletContext servletContext = servletContextEvent.getServletContext();
        DriectoryBiz driectoryBiz = new DriectoryBizImpl();
        List<Map<String, Object>> category = driectoryBiz.getCategory();
        List<Map<String, Object>> brand = driectoryBiz.getBrand();
        servletContext.setAttribute("categorys",category);
        servletContext.setAttribute("brand",brand);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
