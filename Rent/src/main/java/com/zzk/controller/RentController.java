package com.zzk.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzk.domain.Rent;
import com.zzk.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Rent account, HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        account.setUsername(username);
        System.out.println(account);
        rentService.save(account);
        return "保存成功";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll() throws JsonProcessingException {
        List<Rent> rentList = rentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(rentList);
        modelAndView.addObject("rentList",json);
        modelAndView.setViewName("rent-in-msg");
        System.out.println(json);
        return modelAndView;
    }

    @RequestMapping("/findByLocation")
    public ModelAndView findByLocation(@RequestParam("location")  String location){
        List<Rent> rentList = rentService.findByLocation(location);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rentList",rentList);
        modelAndView.setViewName("rentList");
        return modelAndView;
    }
}
