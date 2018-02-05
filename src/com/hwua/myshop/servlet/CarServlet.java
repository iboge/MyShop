package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.impl.FavoritesBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet("/cart")
public class CarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FavoritesBizImpl favoritesBiz = new FavoritesBizImpl();
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        System.out.println("uid = " + uid);
        List<Map<String, Object>> favorite = favoritesBiz.getFavorite(uid);
//        if(favorite!=null){
        req.setAttribute("car",favorite);
        req.getRequestDispatcher("shopcart.jsp").forward(req,resp);
        System.out.println("favorite = " + favorite);
//        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
