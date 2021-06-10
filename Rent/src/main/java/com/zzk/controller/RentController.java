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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/rent")
//租房模块
public class RentController {

    //注入租房模块service层
    @Autowired
    private RentService rentService;

    //用户新增出租信息
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Rent rent, HttpSession httpSession){
        //获取存入session中的用户名
        String username = (String) httpSession.getAttribute("username");
        rent.setUsername(username);
        //将当前时间转换为字符串类型存入数据库中
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        rent.setTime(df.format(new Date()));
        //调用service层的方法实现信息存储
        rentService.save(rent);
        return "1";
    }

    //查找所有没被租出去的房屋
    @RequestMapping(value = "/findAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findByLocation(@RequestParam("page")String page,@RequestParam("limit")String limit,String location) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Rent> rentList,rentList2;
        if(location==null){
            rentList = rentService.findAll2();
            PageHelper.startPage(start,pageSize);
            rentList2 = rentService.findAll2();
        }else{
            System.out.println(location);
            rentList = rentService.findByLocation(location);
            PageHelper.startPage(start,pageSize);
            rentList2 = rentService.findByLocation(location);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(rentList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+rentList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    //查找该用户已租房屋
    @RequestMapping(value = "/findByUser",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findByUser(@RequestParam("page")String page,@RequestParam("limit")String limit,HttpSession httpSession) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Rent> rentList,rentList2;
        String username = (String) httpSession.getAttribute("username");
        rentList = rentService.findByUser(username);
        PageHelper.startPage(start,pageSize);
        rentList2 = rentService.findByUser(username);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(rentList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+rentList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    //此用户已租房屋列表
    @RequestMapping(value = "/findByMark",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findByMark(@RequestParam("page")String page,@RequestParam("limit")String limit,HttpSession httpSession) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Rent> rentList,rentList2;
        String username = (String) httpSession.getAttribute("username");
        rentList = rentService.findByMark(username);
        PageHelper.startPage(start,pageSize);
        rentList2 = rentService.findByMark(username);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(rentList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+rentList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    //修改房价
    @RequestMapping(value = "/changePrice",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String changePrice(@RequestParam("price")String price,@RequestParam("id")String index){
        rentService.change(Integer.parseInt(index),Integer.parseInt(price));
        return "1";
    }

    //此用户租房
    @RequestMapping(value = "/rented",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String rented(@RequestParam("id")String index,HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        String rentedTime;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        rentedTime=df.format(new Date());
        rentService.rented(Integer.parseInt(index),username,rentedTime);
        return "1";
    }

    //删除出租信息
    @RequestMapping(value = "/del")
    @ResponseBody
    public String del(@RequestParam("id")int id){
        rentService.del(id);
        return "1";
    }

}
