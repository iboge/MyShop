package com.hwua.myshop.biz;

import java.util.List;
import java.util.Map;

public interface OrderBiz {

    public int addOrder(Object uid);

    public Map<String, Object> getId(Object uid);

    public int insertOrder(Map<String,Object> map);

    public List<Map<String, Object>> getOrder(Object oid);

    public int delOrder(Object id);
}
