package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.impl.UserBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String tel = req.getParameter("tel");
        String addr = req.getParameter("addr");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        System.out.println("email = " + email);
        System.out.println("tel = " + tel);
        System.out.println("addr = " + addr);
        UserBizImpl userBiz = new UserBizImpl();
        Map<String, Object> map = new HashMap<>();
        map.put("username",username);
        map.put("password",password);
        map.put("email",email);
        map.put("tel",tel);
        map.put("addr",addr);
        int register = userBiz.register(map);
        System.out.println("register = " + register);
        if(register==1){
            //成功
            resp.sendRedirect("login.jsp");
        }else{
            //失败
            resp.sendRedirect("register.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }
}
