package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.impl.GoodsBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class QueryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*GoodsBizImpl goodsBiz = new GoodsBizImpl();
        String cid = req.getParameter("category_id");
        String bid = req.getParameter("brand_id");
        if(cid != null && !"".equals(cid)){
            List<Map<String, Object>> good = goodsBiz.get(cid);
            req.setAttribute("good",good);
            *//*if(){}*//*
        }else if(bid != null && !"".equals(bid)){
            List<Map<String, Object>> good = goodsBiz.getB(bid);
            req.setAttribute("good",good);
        }else{
            List<Map<String, Object>> good = goodsBiz.getAllGoods();
            req.setAttribute("good",good);
        }
        req.getRequestDispatcher("search.jsp").forward(req,resp);*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
