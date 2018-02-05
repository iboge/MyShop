package com.hwua.myshop.biz;

import java.util.List;
import java.util.Map;

public interface FavoritesBiz {
    public int doCreate(Map<String, Object> map);

    public Map<String,Object> getCount(Object uid, String gid);

    public int change(Object id,Object count);

    public List<Map<String,Object>> getFavorite(Object uid);

    public int delFavorite(Object uid,String gid);

    public int del(Object uid);
}
