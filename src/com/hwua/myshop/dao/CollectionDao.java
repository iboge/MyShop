package com.hwua.myshop.dao;

import java.util.List;
import java.util.Map;

public interface CollectionDao {

    public int insertCollection(Map<String,Object> map);

    public List<Map<String,Object>> queryCollection(Object uid);

    public Map<String,Object> queryCollection(Object uid,String gid);

    public int updateCollection(Object uid,String gid);
}
