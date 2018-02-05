package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.OrderBiz;
import com.hwua.myshop.biz.impl.OrderBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delOrder")
public class DelOrderSerlet extends HttpServlet {
    private OrderBiz orderBiz = new OrderBizImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        int i = orderBiz.delOrder(id);
        resp.sendRedirect("queryOrder");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
