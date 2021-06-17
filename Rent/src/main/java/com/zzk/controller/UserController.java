package com.zzk.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.zzk.domain.Review;
import com.zzk.domain.User;
import com.zzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    //用户注册
    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(User user){
        user.setAuth("2");
        userService.save(user);
        System.out.println(user);
        return "1";
    }

    @RequestMapping("/login2")
    public String login2(){
        return "redirect:/login.jsp";
    }

    //用户登录
    @RequestMapping("/login")
    @ResponseBody
    public String login(@RequestParam("username")  String username, @RequestParam("password") String password, HttpSession httpSession){
        //System.out.println(username + " " + password);
        httpSession.setAttribute("username",username);
        User user = userService.ifExist(username, password);
        System.out.println(user);
        if(user==null) return "0";
        httpSession.setAttribute("auth",Integer.parseInt(user.getAuth()));
        return user.getAuth();
    }

    //查看用户名是否被占用
    @RequestMapping("/checkUser")
    @ResponseBody
    public int check(@RequestParam("username")  String username){
//        System.out.println(username + " " + password);
        return userService.ifUser(username)==null?1:0;
    }

    //登出
    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:/login.jsp";
    }

    //用户信息展示
    @RequestMapping(value = "/userCenter",produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public String userCenter(HttpSession httpSession) throws JsonProcessingException {
        String username = (String) httpSession.getAttribute("username");
        User user = userService.ifUser(username);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
//        System.out.println(json);
        return json;
    }

    //修改用户信息
    @RequestMapping("/change")
    @ResponseBody
    public int change(User user){
        System.out.println(user);
        userService.change(user);
        return 1;
    }

    //查找所有用户
    @RequestMapping(value = "/findAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAll(@RequestParam("page")String page,@RequestParam("limit")String limit,String username) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<User> userList,userList2;
        String books = null;
        if(username==null||"".equals(username)){
            userList = userService.findAll();
            PageHelper.startPage(start,pageSize);
            userList2 = userService.findAll();
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(userList2);
            books="{\"code\":0,\"msg\":\"ok\",\"count\":"+userList.size()+",\"data\":"+json+"}";
        }
        else{
            User user = userService.ifUser(username);
            System.out.println(user);
            List<User> users = new ArrayList<User>();
            users.add(user);
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(users);
            books="{\"code\":0,\"msg\":\"ok\",\"count\":"+1+",\"data\":"+json+"}";
        }
        System.out.println(books);
        return books;
    }
}
