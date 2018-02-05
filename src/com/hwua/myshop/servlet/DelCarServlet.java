package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.FavoritesBiz;
import com.hwua.myshop.biz.impl.FavoritesBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/del")
public class DelCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FavoritesBiz favoritesBiz = new FavoritesBizImpl();
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        String gid = req.getParameter("id");
        System.out.println("gid = " + gid);
        System.out.println("uid = " + uid);
        if(gid!=null&&!"".equals(gid)){
            favoritesBiz.delFavorite(uid,gid);
        }else{
            favoritesBiz.del(uid);
        }
        resp.sendRedirect("cart");
}

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
