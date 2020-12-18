package com.edu.uc.controller;

import com.edu.uc.model.entity.Result;
import com.edu.uc.model.entity.User;
import com.edu.uc.utils.RedisUtil;
import com.edu.uc.utils.TokenUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * @Classname LoginController
 * @Description TODO
 * @Author Minghui Sun, Fengjie Gu
 * @Version 1.0
 */
public class LoginController {
    @Autowired
    RedisUtil redisUtil;
    @PostMapping("/login")
    @ResponseBody
    public Result login(String username, String password, HttpServletResponse response) throws JsonProcessingException {
        User user=new User();
        user.setUserName(username);
        user.setPassword(password);
        //去数据库拿密码验证用户名密码，这里直接验证
        if(username.equals("admin")){
            if (!password.equals("admin")){
                return new Result(400,"密码错误");
            }
        }else if (username.equals("user")){
            if (!password.equals("user")){
                return new Result(400,"密码错误");
            }
        }else{
            return new Result(400,"无此用户");
        }
        Long currentTimeMillis = System.currentTimeMillis();
        String token= TokenUtil.sign(username,currentTimeMillis);
        redisUtil.set(username,currentTimeMillis,TokenUtil.REFRESH_EXPIRE_TIME);
        response.setHeader("Authorization", token);
        response.setHeader("Access-Control-Expose-Headers", "Authorization");

        return new Result().OK();
    }
}
