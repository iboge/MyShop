package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.OrderBiz;
import com.hwua.myshop.biz.impl.OrderBizImpl;
import com.hwua.myshop.biz.impl.UserBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
    
    private UserBizImpl userBiz = new UserBizImpl();
    private OrderBiz orderBiz = new OrderBizImpl();
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String returnUrl = req.getParameter("returnUrl");
        System.out.println("returnUrl = " + returnUrl);
        Map<String, Object> login = userBiz.login(username,password);
        if(login!=null){
            if(login.containsKey("error")){
                Object error = login.get("error");
                req.setAttribute("error",error);
                resp.sendRedirect("login.jsp");
                System.out.println("error = " + error);
                req.getRequestDispatcher("login.jsp");
            }else {
                HttpSession session = req.getSession();
                session.setAttribute("uid", login.get("id"));
                session.setAttribute("username", username);
                Map<String, Object> map = orderBiz.getId(login.get("id"));
                if(map==null){
                    int i = orderBiz.addOrder(login.get("id"));
                }
                if (returnUrl != null && !"".equals(returnUrl.trim())) {

                    resp.sendRedirect(returnUrl);
                } else {
                    resp.sendRedirect("home.jsp");
                }
            }
        }else{
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
