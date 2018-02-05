package com.hwua.myshop.biz;

import java.util.Map;

public interface UserBiz {

    public int addCart(String uid);

    public Map<String,Object> login(String username,String password);

    public int register(Map<String,Object> map);

    public int modify(Map<String,Object> map);
}
