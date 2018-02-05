package com.hwua.myshop.test;

import com.hwua.myshop.biz.impl.FavoritesBizImpl;
import com.hwua.myshop.biz.impl.UserBizImpl;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JUNT4 {

    @Test
    public void junt4Test(){
        UserBizImpl userBiz = new UserBizImpl();
        Map<String, Object> guest = userBiz.login("guest", "123456");
        System.out.println(guest.get("id"));
        System.out.println(guest.get("username"));
    }
    
    @Test
    public void junit4Test(){
        FavoritesBizImpl favoritesBiz = new FavoritesBizImpl();
        Map<String, Object> map = new HashMap<>();
        map.put("u_id","1");
        map.put("g_id","1");
        /*map.put("hiredate","");
        map.put("status","0")*/
        int i = favoritesBiz.doCreate(map);
        System.out.println("i = " + i);
    }

    @Test
    public void junit4add(){
        UserBizImpl userBiz = new UserBizImpl();
        int i = userBiz.addCart("1");
        System.out.println("i = " + i);
    }
    @Test
    public void junit4count(){
        FavoritesBizImpl favoritesBiz = new FavoritesBizImpl();
        Map<String, Object> count = favoritesBiz.getCount("1", "2");

        System.out.println(count);
    }

    @Test
    public void junit4getFavorites(){
        FavoritesBizImpl favoritesBiz = new FavoritesBizImpl();
        List<Map<String, Object>> favorite = favoritesBiz.getFavorite("1");
        System.out.println(favorite);
    }
}
