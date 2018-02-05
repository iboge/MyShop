package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.OrderBiz;
import com.hwua.myshop.biz.impl.OrderBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/queryOrder")
public class QueryOrderServlet extends HttpServlet {
    private OrderBiz orderBiz = new OrderBizImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        Map<String, Object> user = orderBiz.getId(uid);
        Object oid = user.get("id");
        List<Map<String, Object>> list = orderBiz.getOrder(oid);
        req.setAttribute("orders",list);
        req.getRequestDispatcher("order.jsp").forward(req,resp);
        System.out.println("list = " + list);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
