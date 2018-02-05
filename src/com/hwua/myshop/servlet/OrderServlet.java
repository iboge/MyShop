package com.hwua.myshop.servlet;

import com.hwua.myshop.biz.FavoritesBiz;
import com.hwua.myshop.biz.GoodsBiz;
import com.hwua.myshop.biz.OrderBiz;
import com.hwua.myshop.biz.impl.FavoritesBizImpl;
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

@WebServlet("/order")
public class OrderServlet extends HttpServlet {

    private OrderBiz orderBiz = new OrderBizImpl();
    private FavoritesBiz favoritesBiz = new FavoritesBizImpl();
    private GoodsBiz goodsBiz = new GoodsBizImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String[] gids = req.getParameterValues("gid");
        String[] counts = req.getParameterValues("count");
        String[] total = req.getParameterValues("cp");
        Object uid = session.getAttribute("uid");
        Map<String, Object> user = orderBiz.getId(uid);
        Object oid = user.get("id");
        for(int i=0;i<gids.length;i++){
            HashMap<String, Object> map = new HashMap<>();
            map.put("o_id",oid);
            map.put("g_id",gids[i]);
            map.put("count",counts[i]);
            map.put("sumoney",total[i]);
            int addOrder = orderBiz.insertOrder(map);
            Map<String, Object> count = goodsBiz.getCount(gids[i]);
            Object count1 = count.get("count");
            int i1 = Integer.parseInt(count1.toString());
            i1=i1-Integer.parseInt(counts[i]);
            int i2 = goodsBiz.delCount(gids[i], i1);
        }
        int del = favoritesBiz.del(uid);
        resp.sendRedirect("queryOrder");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
