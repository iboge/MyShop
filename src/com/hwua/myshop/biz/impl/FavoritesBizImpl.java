package com.hwua.myshop.biz.impl;

import com.hwua.myshop.biz.FavoritesBiz;
import com.hwua.myshop.dao.FavoritesDao;
import com.hwua.myshop.dao.impl.FavoritesDaoImpl;

import java.util.List;
import java.util.Map;

public class FavoritesBizImpl implements FavoritesBiz{
    private FavoritesDao favoritesDao = new FavoritesDaoImpl();
    @Override
    public int doCreate(Map<String, Object> map) {
        return favoritesDao.doCreate(map);
    }

    @Override
    public Map<String, Object> getCount(Object uid, String gid) {
        return favoritesDao.queryCount(uid,gid);
    }

    @Override
    public int change(Object id, Object count) {
        return favoritesDao.updateCount(id,count);
    }

    @Override
    public List<Map<String, Object>> getFavorite(Object uid) {
        return favoritesDao.queryFavorite(uid);
    }

    @Override
    public int delFavorite(Object uid, String gid) {
        return favoritesDao.doDelete(uid,gid);
    }

    @Override
    public int del(Object uid) {
        return favoritesDao.delAll(uid);
    }
}
