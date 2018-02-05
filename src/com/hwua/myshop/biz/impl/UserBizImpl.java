package com.hwua.myshop.biz.impl;

import com.hwua.myshop.biz.UserBiz;
import com.hwua.myshop.dao.UserDao;
import com.hwua.myshop.dao.impl.UserDaoImpl;

import java.util.HashMap;
import java.util.Map;

public class UserBizImpl implements UserBiz{

    private UserDao userDao = new UserDaoImpl();

    @Override
    public int addCart(String uid) {
        return userDao.doInsert(uid);
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> name = userDao.queryByName(username);
        if(name!=null){
            Map<String, Object> user = userDao.queryUser(username, password);
            if(user!=null){
//                map.put("success","登录成功");
                return user;
            }else{
//                map.put("error","用户名和密码不匹配");
                return null;
            }
        }else {
//            map.put ("error", "用户名不存在");
            return null;
        }
    }

    @Override
    public int register(Map<String, Object> map) {
        /*System.out.println("map = " + map);
        int i = userDao.doCreate(map);
        if(i==1){
            return 1;
        }else{
            return 0;
        }*/
        Map<String, Object> name = userDao.queryByName((String) map.get("username"));
        if(name==null){
            Map<String, Object> email = userDao.queryByEmail((String) map.get("email"));
            if(email==null){
                int i = userDao.doCreate(map);
                if(i==1){
                    //成功
                    return 1;
                }
                //失败
                return -1;
            }
            //邮箱已存在
            return -2;
        }
        //用户名已存在
        return 0;
    }

    @Override
    public int modify(Map<String,Object> map) {
        Map<String, Object> user = userDao.queryByNE((String)map.get("username"),(String)map.get("email"));
        if(user!=null){
            int i = userDao.doUpdate((String) user.get("id"), (String) map.get("password"));
            if(i==1){
                //成功
                return 1;
            }
            //失败
            return -1;
        }
        //没找到相匹配用户名和邮箱
        return 0;
    }
}
