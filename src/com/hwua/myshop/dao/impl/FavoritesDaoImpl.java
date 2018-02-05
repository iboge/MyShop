package com.hwua.myshop.dao.impl;

import com.hwua.myshop.dao.FavoritesDao;
import com.hwua.myshop.util.CommonDao;

import java.util.List;
import java.util.Map;

public class FavoritesDaoImpl extends CommonDao implements FavoritesDao{
    @Override
    public int doCreate(Map<String, Object> map) {
        String sql = "INSERT INTO t_favorite VALUES(seq_t_favorite_id.nextval,?,?,1)";
        return executeUpdate(sql,map.get("u_id"),map.get("g_id"));
    }

    @Override
    public Map<String,Object> queryCount(Object uid, String gid) {
        String sql = "SELECT * FROM t_favorite WHERE u_id=? AND g_id=?";
        return query4Map(sql,uid,gid);

    }

    @Override
    public int updateCount(Object id,Object count) {
        String sql = "UPDATE t_favorite SET count=? WHERE id=?";
        return executeUpdate(sql,count,id);
    }

    @Override
    public List<Map<String, Object>> queryFavorite(Object uid) {
        String sql = "SELECT f.id id,f.u_id u_id,g.id g_id,g.name g_name,g.price g_price,g.image g_image,f.count f_count FROM T_FAVORITE f,T_GOODS g WHERE f.g_id=g.id AND f.u_id=?";
        return query4MapList(sql,uid);
    }

    @Override
    public int doDelete(Object uid,String gid) {
        String sql = "DELETE t_favorite WHERE u_id=? AND g_id=?";
        return executeUpdate(sql,uid,gid);
    }

    @Override
    public int delAll(Object uid) {
        String sql = "DELETE t_favorite WHERE u_id=?";
        return executeUpdate(sql,uid);
    }
}
