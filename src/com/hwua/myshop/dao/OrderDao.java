package com.hwua.myshop.dao;

import java.util.List;
import java.util.Map;

public interface OrderDao {

    public int createOrder(Object uid);

    public Map<String,Object> queryId(Object uid);

    public int createOrderInfo(Map<String,Object> map);

    public List<Map<String,Object>> queryOrder(Object oid);

    public int updateOrder(Object id);
}
