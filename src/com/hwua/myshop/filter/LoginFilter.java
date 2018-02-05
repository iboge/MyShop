package com.hwua.myshop.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName="LoginFilter")
public class LoginFilter extends HttpFilter{

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        Object username = request.getSession().getAttribute("username");
        if(username!=null){
            filterChain.doFilter(request,response);
            return;
        }
        System.out.println("未登录");
/*
        response.sendRedirect("login.jsp?returnUrl="+uri+"&id="+request.getParameter("id"));
*/
//        response.setHeader("refresh","1;/myshop/login.jsp?returnUrl="+uri);
        response.sendRedirect("/myshop/login.jsp?returnUrl="+uri/*"/myshop/cart"*/);
    }
}
