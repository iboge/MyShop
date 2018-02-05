package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.CollectionBiz;
import com.hwua.myshop.biz.impl.CollectionBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/queryCollection")
public class QueryCollectionServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CollectionBiz collectionBiz = new CollectionBizImpl();
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        List<Map<String, Object>> collection = collectionBiz.getCollection(uid);
        req.setAttribute("collection",collection);
        req.getRequestDispatcher("collection.jsp").forward(req,resp);
        System.out.println("collection = " + collection);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
