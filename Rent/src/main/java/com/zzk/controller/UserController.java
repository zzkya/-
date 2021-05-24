package com.zzk.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzk.domain.User;
import com.zzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(User user){
        userService.save(user);
        user.setAuth(2);
        System.out.println(user);
        return "1";
    }

    @RequestMapping("/login2")
    public String login2(){
        return "redirect:/login.jsp";
    }

    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam("username")  String username, @RequestParam("password") String password, HttpSession httpSession){
        //System.out.println(username + " " + password);
        httpSession.setAttribute("username",username);
        User user = userService.ifExist(username, password);
        if(user==null) return 0;
        httpSession.setAttribute("auth",user.getAuth());
        return 1;
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public int check(@RequestParam("username")  String username){
//        System.out.println(username + " " + password);
        return userService.ifUser(username)==null?1:0;
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "/WEB-INF/login.jsp";
    }

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

    @RequestMapping("/change")
    @ResponseBody
    public int change(User user){
        System.out.println(user);
        userService.change(user);
        return 1;
    }
}
