package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.GoodsBiz;
import com.hwua.myshop.biz.impl.GoodsBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/introduction")
public class IntroductionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsBiz goodsDao = new GoodsBizImpl();
        String id = req.getParameter("id");
//        System.out.println("id = " + id);
        Map<String, Object> good = goodsDao.getGood(id);
//        System.out.println(good.get("price")+"-------"+good.get("id"));

//        System.out.println("good = " + good);
        req.setAttribute("good",good);
        req.getRequestDispatcher("introduction.jsp").forward(req,resp);
    }
}
