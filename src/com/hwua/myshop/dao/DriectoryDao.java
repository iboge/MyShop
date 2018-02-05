package com.hwua.myshop.dao;

import java.util.List;
import java.util.Map;

public interface DriectoryDao {

    /**
     * 所有分类
     * @return
     */
    public List<Map<String,Object>> queryCategory();

    /**
     * 所有品牌
     * @return
     */
    public List<Map<String,Object>> queryBrand();

}
