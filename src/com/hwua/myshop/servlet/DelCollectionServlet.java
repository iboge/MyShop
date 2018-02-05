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

@WebServlet("/delCollection")
public class DelCollectionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CollectionBiz collectionBiz = new CollectionBizImpl();
        String gid = req.getParameter("id");
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        System.out.println("uid = " + uid);
        System.out.println("gid = " + gid);
        int i = collectionBiz.delCollection(uid, gid);
        if (i == 1){
            resp.sendRedirect("queryCollection");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
