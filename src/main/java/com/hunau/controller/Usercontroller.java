package com.hunau.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.util.StringUtil;
import com.hunau.bean.User;
import com.hunau.bean.message;
import com.hunau.service.userService;
import com.hunau.util.BufferReaderUtils;
import com.hunau.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

/**
 * @author Wking
 * @create 2020-12-04 9:08
 */
@RequestMapping("/user")
@RestController
public class Usercontroller {
    @Autowired
    userService userService;
    @ResponseBody
    @CrossOrigin("http://localhost:8080/user/login")
    @RequestMapping(value = "/login")
    public String login(HttpServletRequest request, User u) throws IOException {
        System.out.println(u.getUsername());
        System.out.println(u);
        User user = userService.selectUser(u.getUsername(),u.getPassword());
        if(user==null)
        {
            System.out.println(user);
            return JsonUtils.objectToJson(new message("用户名或密码错误",false));
        }
        else{
            System.out.println(user);
            return JsonUtils.objectToJson(new message("登录成功",true));
        }

    }

    @ResponseBody
@RequestMapping("/register")
    @CrossOrigin("http://localhost:8080/user/register")
    public String register( @RequestBody  User u){
        System.out.println(u);
        int i = userService.insertUser(u);
        if(i==0)
        {
            return JsonUtils.objectToJson(new message("注册失败",false));
        }
        else{
            return JsonUtils.objectToJson(new message("注册成功",true));
        }
    }

}
