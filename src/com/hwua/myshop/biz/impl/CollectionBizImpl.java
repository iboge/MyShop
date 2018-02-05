package com.hwua.myshop.biz.impl;

import com.hwua.myshop.biz.CollectionBiz;
import com.hwua.myshop.dao.CollectionDao;
import com.hwua.myshop.dao.impl.CollectionDaoImpl;

import java.util.List;
import java.util.Map;

public class CollectionBizImpl implements CollectionBiz{

    private CollectionDao collectionDao = new CollectionDaoImpl();
    @Override
    public int addCollection(Map<String, Object> map) {
        return collectionDao.insertCollection(map);
    }

    @Override
    public List<Map<String, Object>> getCollection(Object uid) {
        return collectionDao.queryCollection(uid);
    }

    @Override
    public Map<String, Object> getCollection(Object uid, String gid) {
        return collectionDao.queryCollection(uid,gid);
    }

    @Override
    public int delCollection(Object uid, String gid) {
        return collectionDao.updateCollection(uid,gid);
    }
}
