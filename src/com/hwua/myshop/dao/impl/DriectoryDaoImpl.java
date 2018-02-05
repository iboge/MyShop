package com.hwua.myshop.dao.impl;

import com.hwua.myshop.dao.DriectoryDao;
import com.hwua.myshop.util.CommonDao;

import java.util.List;
import java.util.Map;

public class DriectoryDaoImpl extends CommonDao implements DriectoryDao {
    @Override
    public List<Map<String, Object>> queryCategory() {
//        String sql = "SELECT DISTINCT c.ID,c.NAME FROM T_DRIECTORY d,T_CATEGORY c WHERE d.B_ID=c.ID ORDER BY c.ID";
        String sql = "SELECT ID,NAME FROM T_CATEGORY ORDER BY ID";
        return query4MapList(sql);
    }

    @Override
    public List<Map<String, Object>> queryBrand() {
        String sql = "SELECT ID,NAME FROM T_BRAND ORDER BY ID";
        return query4MapList(sql);
    }

}
