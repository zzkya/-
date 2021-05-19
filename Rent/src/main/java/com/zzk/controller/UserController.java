package com.zzk.controller;


import com.zzk.domain.Rent;
import com.zzk.domain.User;
import com.zzk.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("/login")
    @ResponseBody
    public int login(@RequestParam("username")  String username, @RequestParam("password") String password, HttpSession httpSession){
//        System.out.println(username + " " + password);
        httpSession.setAttribute("username",username);
        return userService.ifExist(username,password)==null?0:1;
    }

    @RequestMapping("/checkUser")
    @ResponseBody
    public int check(@RequestParam("username")  String username){
//        System.out.println(username + " " + password);
        return userService.ifUser(username)==null?1:0;
    }

    @RequestMapping("logout")
    public String logout(HttpSession httpSession){
        httpSession.invalidate();
        return "redirect:login";
    }
}
