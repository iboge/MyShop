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

@WebServlet("/like")
public class LikeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("index_none_header_sysc");
        System.out.println("name = " + name);
        GoodsBizImpl goodsBiz = new GoodsBizImpl();
        List<Map<String, Object>> like = goodsBiz.getLike(name);
        if(like!=null){
            req.setAttribute("good",like);
        }
        System.out.println("like = " + like);
        req.getRequestDispatcher("search.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
