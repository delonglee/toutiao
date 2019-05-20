package com.nowCoder.toutiao.controller;

import com.nowCoder.toutiao.service.UserServicce;
import com.nowCoder.toutiao.util.ToutiaoUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.logging.Logger;

@Controller
public class LoginController {
    private static final Logger logger = LoggerFactory.getLogger(LoginController.class)

    @Autowired
    UserServicce userServicce;

    /*注册*/
    @RequestMapping(path = {"/reg/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String reg(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "rememberme", defaultValue = "0") int rememberme) {

            try {
              Map<String, Object> map = userServicce.register(username,password);
              if(map.isEmpty){
                  return ToutiaoUtil.getJSONString(0, "注册成功")；
                } else {
                  return ToutiaoUtil.getJSONString(1, map)；
                }

            } catch (Exception) {
                logger.error("注册异常" + e.getMessage());
                return ToutiaoUtil.getJSONString(1, "注册异常");
            }

    }

}

    /*登录*/
    @RequestMapping(path = {"/login/"}, method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String login(Model model, @RequestParam("username") String username,
                        @RequestParam("password") String password,
                        @RequestParam(value = "rememberme", defaultValue = "0") int rememberme) {

        try {
            Map<String, Object> map = userServicce.register(username,password);
            if(map isEmpty){
                return ToutiaoUtil.getJSONString(0, "注册成功")；
            } else {
                return ToutiaoUtil.getJSONString(1, map)；
            }

        } catch (Exception) {
            logger.error("注册异常" + e.getMessage());
            return ToutiaoUtil.getJSONString(1, "注册异常");
        }

    }






















