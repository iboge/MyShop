package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.impl.FavoritesBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/favorites")
public class FavoritesServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FavoritesBizImpl favoritesBiz = new FavoritesBizImpl();
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        System.out.println("uid = " + uid);
        String gid = req.getParameter("id");
        System.out.println("gid = " + gid);
        Map<String, Object> map = new HashMap<>();
        map.put("u_id",uid);
        map.put("g_id",gid);
        if(uid!=null) {
            Map<String, Object> map1 = favoritesBiz.getCount(uid, gid);
            System.out.println("map1 = " + map1);
            if(map1!=null){
                int count = Integer.parseInt(map1.get("count").toString());
                count=count+1;
                System.out.println("count = " + count);
                Object id = map1.get("id");
                System.out.println("id = " + id);
                int change = favoritesBiz.change(id, count);
                if(change==1){
                    resp.sendRedirect("cart");
                }
            }else {
                int i = favoritesBiz.doCreate(map);
                if (i == 1) {
                    resp.sendRedirect("cart");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/introduction?id=" + gid);
                }
            }
        }else{
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
