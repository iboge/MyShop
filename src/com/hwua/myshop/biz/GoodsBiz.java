package com.hwua.myshop.biz;

import java.util.List;
import java.util.Map;

public interface GoodsBiz {
    public Map<String,Object> getCount(Object gid);

    public int delCount(Object gid,Object count);

    public List<Map<String,Object>> getLike(String str);

    public Map<String, Object> getGood(String id);

    public List<Map<String,Object>> getB(String id);

    public List<Map<String,Object>> get(String id);

    public List<Map<String,Object>> get1();

    public List<Map<String,Object>> get2();

    public List<Map<String,Object>> get3();

    public List<Map<String,Object>> getAllGoods();

    public List<Map<String,Object>> getAllHW();

}
