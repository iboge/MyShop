package com.hwua.myshop.biz.impl;

import com.hwua.myshop.biz.DriectoryBiz;
import com.hwua.myshop.dao.DriectoryDao;
import com.hwua.myshop.dao.impl.DriectoryDaoImpl;

import java.util.List;
import java.util.Map;

public class DriectoryBizImpl implements DriectoryBiz {

    private DriectoryDao driectoryDao = new DriectoryDaoImpl();

    @Override
    public List<Map<String, Object>> getBrand() {
        List<Map<String, Object>> maps = driectoryDao.queryBrand();
        return maps;
    }

    @Override
    public List<Map<String, Object>> getCategory() {
        List<Map<String, Object>> maps = driectoryDao.queryCategory();
        return maps;
    }

}
