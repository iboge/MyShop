package com.hwua.myshop.biz.impl;

import com.hwua.myshop.biz.GoodsBiz;
import com.hwua.myshop.dao.GoodsDao;
import com.hwua.myshop.dao.impl.GoodsDaoImpl;

import java.util.List;
import java.util.Map;

public class GoodsBizImpl implements GoodsBiz {

    private GoodsDao goodsDao = new GoodsDaoImpl();

    @Override
    public Map<String, Object> getCount(Object gid) {
        return goodsDao.queryCount(gid);
    }

    @Override
    public int delCount(Object gid, Object count) {
        return goodsDao.updateCount(gid,count);
    }

    @Override
    public List<Map<String, Object>> getLike(String str) {
        List<Map<String, Object>> like = goodsDao.like(str);
        return like;
    }

    @Override
    public Map<String, Object> getGood(String id) {
        Map<String, Object> good = goodsDao.queryGood(id);
        return good;
    }

    @Override
    public List<Map<String, Object>> getB(String id) {
        List<Map<String, Object>> maps = goodsDao.queryB(id);
        return maps;
    }

    @Override
    public List<Map<String, Object>> get(String id) {
        List<Map<String, Object>> list = goodsDao.queryC(id);
        return list;
    }

    @Override
    public List<Map<String, Object>> get1() {
        List<Map<String, Object>> maps = goodsDao.query1();
        return maps;
    }

    @Override
    public List<Map<String, Object>> get2() {
        List<Map<String, Object>> maps = goodsDao.query2();
        return maps;
    }

    @Override
    public List<Map<String, Object>> get3() {
        List<Map<String, Object>> maps = goodsDao.query3();
        return maps;
    }

    @Override
    public List<Map<String, Object>> getAllGoods() {
        List<Map<String, Object>> goods = goodsDao.queryAllGoods();
        return goods;
    }

    @Override
    public List<Map<String, Object>> getAllHW() {
        List<Map<String, Object>> maps = goodsDao.queryAllHW();
        return maps;
    }

}
