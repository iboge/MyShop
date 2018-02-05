package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.CollectionBiz;
import com.hwua.myshop.biz.GoodsBiz;
import com.hwua.myshop.biz.impl.CollectionBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/collection")
public class CollectionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CollectionBiz collectionBiz = new CollectionBizImpl();
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        System.out.println("uid = " + uid);
        if(uid!=null) {
            String gid = req.getParameter("id");
            System.out.println("gid = " + gid);
            Map<String, Object> collection = collectionBiz.getCollection(uid, gid);
            if(collection!=null) {
                resp.sendRedirect("queryCollection");
            }else {
                Map<String, Object> map = new HashMap<>();
                map.put("u_id", uid);
                map.put("g_id", gid);
                int i = collectionBiz.addCollection(map);
                if (i == 1) {
                    resp.sendRedirect("queryCollection");
                } else {
                    resp.sendRedirect(req.getContextPath() + "/introduction?id=" + gid);
                }

            }
        }else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
