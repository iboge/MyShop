package com.hwua.myshop.dao.impl;

import com.hwua.myshop.dao.UserDao;
import com.hwua.myshop.util.CommonDao;

import java.util.Map;

public class UserDaoImpl extends CommonDao implements UserDao {

    @Override
    public int doInsert(String uid) {
        String sql = "INSERT INTO T_CART VALUES(seq_t_cart_id.nextval,?)";
        return executeUpdate(sql,uid);
    }

    //通过用户名查询用户是否存在
    @Override
    public Map<String, Object> queryByName(String username) {
        String sql = "SELECT * FROM t_user WHERE username = ?";
        return query4Map(sql,username);
    }

    @Override
    public Map<String, Object> queryByEmail(String email) {
        String sql = "SELECT * FROM t_user WHERE email = ?";
        return query4Map(sql,email);
    }

    //登陆时判断用户名和密码是否匹配
    @Override
    public Map<String, Object> queryUser(String username, String password) {
        String sql = "SELECT * FROM t_user WHERE username = ? AND password = ?";
        return query4Map(sql,username,password);
    }

    //注册新用户
    @Override
    public int doCreate(Map<String, Object> map) {
        String sql = "INSERT INTO t_user VALUES (seq_t_user_id.nextval,?,?,?,?,100000,?)";
        return executeUpdate(sql,map.get("username"),map.get("password"),map.get("tel"),map.get("email"),map.get("addr"));
    }

    //修改密码时判断用户名和密码是否匹配
    @Override
    public Map<String, Object> queryByNE(String username, String email) {
        return null;
    }

    //修改密码
    @Override
    public int doUpdate(String id,String password) {
        String sql = "UPDATE t_user SET password = ? WHERE id = ?";
        return executeUpdate(sql,id,password);
    }
}
