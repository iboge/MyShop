package com.hwua.myshop.dao;

import java.util.List;
import java.util.Map;

public interface GoodsDao {
    public Map<String,Object> queryCount(Object gid);

    public int updateCount(Object gid,Object count);

    public List<Map<String,Object>> like(String str);

    //c_id=1
    public List<Map<String,Object>> query1();

    //c_id=2
    public List<Map<String,Object>> query2();

    //c_id=3
    public List<Map<String,Object>> query3();

    public List<Map<String,Object>> queryAllGoods();

    public List<Map<String,Object>> queryAllHW();

    public List<Map<String,Object>> queryC(String id);

    public List<Map<String,Object>> queryB(String id);

    public Map<String,Object> queryGood(String id);
}
