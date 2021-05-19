package com.zzk.controller;


import com.zzk.domain.Rent;
import com.zzk.domain.User;
import com.zzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(User user){
        try {
            userService.save(user);
        }
        catch (Exception e){
            return "no";
        }
        return "成功";
    }

    @RequestMapping("/login")
    public ModelAndView login(User user){
        boolean ifExist = userService.ifExist(user);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("ifExist",ifExist);
        modelAndView.setViewName("login");
        return modelAndView;
    }

}
