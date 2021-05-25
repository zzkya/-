package com.zzk.controller;


import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.zzk.domain.Rent;
import com.zzk.service.RentService;
import org.apache.ibatis.annotations.Param;
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

    @RequestMapping(value = "/findAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAll(@RequestParam("page")String page,@RequestParam("limit")String limit) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Rent> rentList = rentService.findAll((start-1)*pageSize,pageSize);
        List<Rent> rentList2 = rentService.findAll2();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(rentList);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+rentList2.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    @RequestMapping("/findByLocation")
    @ResponseBody
    public String findByLocation(@RequestParam("page")String page,@RequestParam("limit")String limit,@RequestParam("location")  String location) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Rent> rentList = rentService.findByLocation(location);
        PageHelper.startPage(start,pageSize);
        List<Rent> rentList2 = rentService.findByLocation(location);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(rentList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+rentList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    @RequestMapping(value = "/findByUser",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findByUser(@RequestParam("page")String page,@RequestParam("limit")String limit,HttpSession httpSession) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        String username = (String) httpSession.getAttribute("username");
        List<Rent> rentList = rentService.findByUser(username);
        PageHelper.startPage(start,pageSize);
        List<Rent> rentList2 = rentService.findByUser(username);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(rentList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+rentList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

}
