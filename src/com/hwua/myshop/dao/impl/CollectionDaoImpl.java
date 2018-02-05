package com.hwua.myshop.dao.impl;

import com.hwua.myshop.dao.CollectionDao;
import com.hwua.myshop.util.CommonDao;

import java.util.List;
import java.util.Map;

public class CollectionDaoImpl extends CommonDao implements CollectionDao {
    @Override
    public int insertCollection(Map<String, Object> map) {
        String sql = "INSERT INTO t_collection VALUES (seq_t_collection_id.nextval,?,?,1)";
        return executeUpdate(sql,map.get("u_id"),map.get("g_id"));
    }

    @Override
    public List<Map<String, Object>> queryCollection(Object uid) {
        String sql = "SELECT g.id gid,g.name name,g.price price,g.image image FROM t_goods g,(SELECT id,u_id,g_id FROM t_collection WHERE u_id=? AND status=1) c WHERE g.id=c.g_id ORDER BY c.id DESC";
        return query4MapList(sql,uid);
    }

    @Override
    public Map<String, Object> queryCollection(Object uid, String gid) {
        String sql = "SELECT * FROM t_collection WHERE u_id=? AND g_id=? AND status=1";
        return query4Map(sql,uid,gid);
    }

    @Override
    public int updateCollection(Object uid, String gid) {
        String sql = "UPDATE t_collection SET status=0 WHERE u_id=? AND g_id=?";
        return executeUpdate(sql,uid,gid);
    }
}
