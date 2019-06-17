package com.nowCoder.toutiao.service;

import com.nowCoder.toutiao.dao.UserDAO;
import com.nowCoder.toutiao.moder.User;
import com.nowCoder.toutiao.util.ToutiaoUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

@Service
public class UserServicce {
    @Autowired
    private UserDAO userDAO;

    /*注册密码*/
    public Map<String, Object> register(String username, String password) {
       Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isBlank(username)){
        map.put("msgname", "用户名不能为空");
        return map;
        }

        if(StringUtils.isBlank(password)){
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user != null) {
            map.put("msgname", "用户名已经被注册");
            return map;
        }
        /*密码加密,设置密码强度*/
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeader("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000));
        user.setPassword(ToutiaoUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);
    }

    /*登录密码*/
    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<String, Object>();
        if(StringUtils.isBlank(username)){
            map.put("msgname", "用户名不能为空");
            return map;
        }

        if(StringUtils.isBlank(password)){
            map.put("msgpwd", "密码不能为空");
            return map;
        }

        User user = userDAO.selectByName(username);

        if (user == null) {
            map.put("msgname", "用户不存在");
            return map;
        }

        if (!ToutiaoUtil.MD5(password+user.getSalt()).equals(user.getPassword()) {
            map.put("msgpwd", "密码不正确");
            return map;
        }
        /*密码加密,设置密码强度*/
        user = new User();
        user.setName(username);
        user.setSalt(UUID.randomUUID().toString().substring(0,5));
        user.setHeader("http://images.nowcoder.com/head/%dt.png",new Random().nextInt(1000)))
        user.setPassword(ToutiaoUtil.MD5(password+user.getSalt()));
        userDAO.addUser(user);
    }

    public User getUser(int id) {
        return userDAO.selectById(id);
    }
}















