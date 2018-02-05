package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.GoodsBiz;
import com.hwua.myshop.biz.OrderBiz;
import com.hwua.myshop.biz.impl.GoodsBizImpl;
import com.hwua.myshop.biz.impl.OrderBizImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/addOrder")
public class AddOrderServlet extends HttpServlet {
    private OrderBiz orderBiz = new OrderBizImpl();
    private GoodsBiz goodsBiz = new GoodsBizImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Object uid = session.getAttribute("uid");
        System.out.println("uid = " + uid);
        if(uid!=null) {
            String gid = req.getParameter("id");
            System.out.println("gid = " + gid);
            Map<String, Object> user = orderBiz.getId(uid);
            Map<String, Object> good = goodsBiz.getGood(gid);
            Object price = good.get("price");
            Object oid = user.get("id");
            HashMap<String, Object> map = new HashMap<>();
            map.put("o_id", oid);
            map.put("g_id", gid);
            map.put("count", 1);
            map.put("sumoney", price);
            int addOrder = orderBiz.insertOrder(map);
            Map<String, Object> count = goodsBiz.getCount(gid);
            Object count1 = count.get("count");
            int i1 = Integer.parseInt(count1.toString());
            i1 = i1 - 1;
            int i2 = goodsBiz.delCount(gid, i1);
            resp.sendRedirect("queryOrder");
        }else {
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
