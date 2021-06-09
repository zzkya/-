package com.zzk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.zzk.domain.Rent;
import com.zzk.domain.Tenant;
import com.zzk.service.TenantService;
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
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    //发布求租信息
    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Tenant tenant, HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        tenant.setUsername(username);
//        tenant.setTime(new Date());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        tenant.setTime(df.format(new Date()));
        tenantService.save(tenant);
        System.out.println(tenant);
        return "1";
    }

    //查找所有求租信息
    @RequestMapping(value = "/findAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findByLocation(@RequestParam("page")String page,@RequestParam("limit")String limit,String location) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Tenant> tenantList,tenantList2;
        if(location==null){
            tenantList = tenantService.findAll((start-1)*pageSize,pageSize);
            tenantList2 = tenantService.findAll2();
        }else{
            System.out.println(location);
            tenantList = tenantService.findByLocation(location);
            PageHelper.startPage(start,pageSize);
            tenantList2 = tenantService.findByLocation(location);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(tenantList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+tenantList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    //查找此用户发布的所有求租信息
    @RequestMapping(value = "/findByUser",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findByUser(@RequestParam("page")String page,@RequestParam("limit")String limit,HttpSession httpSession) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        String username = (String) httpSession.getAttribute("username");
        List<Tenant> tenantList,tenantList2;
        tenantList = tenantService.findByUser(username);
        PageHelper.startPage(start,pageSize);
        tenantList2 = tenantService.findByUser(username);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(tenantList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+tenantList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    //修改期望价格
    @RequestMapping(value = "/changePrice",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String changePrice(@RequestParam("expectedPrice")String expectedPrice,@RequestParam("id")String index){
        tenantService.change(Integer.parseInt(index),Integer.parseInt(expectedPrice));
        System.out.println(index+" "+expectedPrice);
        return "1";
    }

    //删除此条求租信息
    @RequestMapping(value = "/del")
    @ResponseBody
    public String del(@RequestParam("id")int id){
        System.out.println(id);
        tenantService.del(id);
        return "1";
    }
}
