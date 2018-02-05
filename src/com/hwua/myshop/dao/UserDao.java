package com.hwua.myshop.dao;

import java.util.Map;

public interface UserDao {

    public int doInsert(String uid);

    /**
     * 用户是否存在
     * @param username 用户名
     * @return
     */
    public Map<String, Object> queryByName(String username);

    /**
     * 邮箱是否存在
     * @param email 用户名
     * @return
     */
    public Map<String, Object> queryByEmail(String email);

    /**
     * 登录：用户名和密码是否匹配
     * @param username 用户名
     * @param password 密码
     * @return
     */
    public Map<String, Object> queryUser(String username,String password);

    /**
     * 注册新用户
     * @param map 存放用户信息
     * @return
     */
    public int doCreate(Map<String,Object> map);

    /**
     * 判断用户名和邮箱是否匹配
     * @param username 用户名
     * @param email 邮箱
     * @return
     */
    public Map<String, Object> queryByNE(String username,String email);

    /**
     * 修改密码
     * @param id 要修改用户的id
     * @param password 要修改的密码
     * @return
     */
    public int doUpdate(String id,String password);
}
