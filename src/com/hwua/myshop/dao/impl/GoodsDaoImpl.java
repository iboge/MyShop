package com.hwua.myshop.dao.impl;

import com.hwua.myshop.dao.GoodsDao;
import com.hwua.myshop.util.CommonDao;

import java.util.List;
import java.util.Map;

public class GoodsDaoImpl extends CommonDao implements GoodsDao{
    @Override
    public Map<String, Object> queryCount(Object gid) {
        String sql = "SELECT * FROM t_goods WHERE id=?";
        return query4Map(sql,gid);
    }

    @Override
    public int updateCount(Object gid,Object count) {
        String sql = "UPDATE t_goods SET count=? WHERE id=?";
        return executeUpdate(sql,count,gid);
    }

    @Override
    public List<Map<String, Object>> like(String str) {
        String sql = "SELECT * FROM T_GOODS WHERE NAME LIKE "+"'%"+str+"%'"+" AND count>0";
//        String name = "'%"+str+"%'";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> query1() {
        String sql = "SELECT ROWNUM,ID,NAME,PRICE,IMAGE FROM T_GOODS WHERE CATEGORY_ID=1 AND count>0 ORDER BY PRICE DESC";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> query2() {
        String sql = "SELECT ROWNUM,ID,NAME,PRICE,IMAGE FROM T_GOODS WHERE CATEGORY_ID=2 AND count>0 ORDER BY PRICE DESC";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> query3() {
        String sql = "SELECT ROWNUM,ID,NAME,PRICE,IMAGE FROM T_GOODS WHERE CATEGORY_ID=3 AND count>0 ORDER BY PRICE DESC";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> queryAllGoods() {
        String sql = "SELECT ROWNUM,ID,NAME,PRICE,IMAGE FROM T_GOODS WHERE count>0";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> queryAllHW() {
        String sql = "SELECT ROWNUM,ID,NAME,PRICE,IMAGE FROM T_GOODS WHERE BRAND_ID=14 AND count>0";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> queryC(String id) {
        String sql = "SELECT * FROM T_GOODS WHERE CATEGORY_ID=? AND count>0";
        return query4MapList(sql,id);
    }

    @Override
    public List<Map<String, Object>> queryB(String id) {
        String sql = "SELECT * FROM T_GOODS WHERE BRAND_ID=? AND count>0";
        return query4MapList(sql,id);
    }

    @Override
    public Map<String, Object> queryGood(String id) {
        String sql ="SELECT * FROM T_GOODS WHERE ID=? ";
        return query4Map(sql,id);
    }
}
