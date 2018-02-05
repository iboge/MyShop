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

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsBizImpl goodsBiz = new GoodsBizImpl();
        String id = req.getParameter("category_id");
        if(id != null && !"".equals(id)){
            List<Map<String, Object>> good = goodsBiz.get(id);
            req.setAttribute("good",good);
            System.out.println("good = " + good);
        }else{
            List<Map<String, Object>> good = goodsBiz.getAllGoods();
            req.setAttribute("good",good);
            System.out.println("good = " + good);
        }
        req.getRequestDispatcher("search.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}


