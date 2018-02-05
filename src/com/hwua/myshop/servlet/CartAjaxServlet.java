package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.impl.FavoritesBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/cartajax")
public class CartAjaxServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FavoritesBizImpl favoritesBiz = new FavoritesBizImpl();
        String gid = req.getParameter("gid");
        String count = req.getParameter("count");
        req.getParameter("count");
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        Map<String, Object> map = favoritesBiz.getCount(uid, gid);
        Object id = map.get("id");
        if(map!=null){
            int change = favoritesBiz.change(id, count);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
