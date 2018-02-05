package com.hwua.myshop.biz;

import java.util.List;
import java.util.Map;

public interface CollectionBiz {

    public int addCollection(Map<String,Object> map);

    public List<Map<String,Object>> getCollection(Object uid);

    public Map<String,Object> getCollection(Object uid,String gid);

    public int delCollection(Object uid,String gid);
}
