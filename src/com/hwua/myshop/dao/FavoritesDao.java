package com.hwua.myshop.dao;

import java.util.List;
import java.util.Map;

public interface FavoritesDao {

    public int doCreate(Map<String, Object> map);

    public Map<String,Object> queryCount(Object uid, String gid);

    public int updateCount(Object id,Object count);

    public List<Map<String,Object>> queryFavorite(Object uid);

    public int doDelete(Object uid,String gid);

    public int delAll(Object uid);
}
