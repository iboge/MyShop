package com.hwua.myshop.biz.impl;

import com.hwua.myshop.biz.OrderBiz;
import com.hwua.myshop.dao.OrderDao;
import com.hwua.myshop.dao.impl.OrderDaoImpl;

import java.util.List;
import java.util.Map;

public class OrderBizImpl implements OrderBiz {

    private OrderDao orderDao = new OrderDaoImpl();

    @Override
    public int addOrder(Object uid) {
        return orderDao.createOrder(uid);
    }

    @Override
    public Map<String, Object> getId(Object uid) {
        return orderDao.queryId(uid);
    }

    @Override
    public int insertOrder(Map<String, Object> map) {
        return orderDao.createOrderInfo(map);
    }

    @Override
    public List<Map<String, Object>> getOrder(Object oid) {
        return orderDao.queryOrder(oid);
    }

    @Override
    public int delOrder(Object id) {
        return orderDao.updateOrder(id);
    }
}
