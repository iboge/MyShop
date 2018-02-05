package com.hwua.myshop.dao.impl;

import com.hwua.myshop.dao.OrderDao;
import com.hwua.myshop.util.CommonDao;

import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends CommonDao implements OrderDao {
    @Override
    public int createOrder(Object uid) {
        String sql = "INSERT INTO t_order VALUES(seq_t_order_id.nextval,?)";
        return executeUpdate(sql,uid);
    }

    @Override
    public Map<String, Object> queryId(Object uid) {
        String sql = "SELECT * FROM t_order WHERE u_id=?";
        return query4Map(sql,uid);
    }

    @Override
    public int createOrderInfo(Map<String,Object> map) {
        String sql = "INSERT INTO t_orderinfo VALUES (seq_t_order_id.nextval,?,?,?,?,sysdate,1)";
        return executeUpdate(sql,map.get("o_id"),map.get("g_id"),map.get("count"),map.get("sumoney"));
    }

    @Override
    public List<Map<String, Object>> queryOrder(Object oid) {
        String sql = "SELECT o.id id,g.name name,g.image image,(sumoney/o.count) price,o.count count,o.sumoney sumoney,o.hiredate hiredate FROM T_GOODS g,(SELECT id,g_id,count,sumoney,hiredate,status FROM T_ORDERINFO WHERE o_id=?) o WHERE g.id=o.g_id AND o.status=1 ORDER BY o.id DESC";
        return query4MapList(sql,oid);
    }

    @Override
    public int updateOrder(Object id) {
        String sql = "UPDATE t_orderinfo SET status=0 WHERE id=?";
        return executeUpdate(sql,id);
    }

}
