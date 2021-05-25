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
import java.util.List;

@Controller
@RequestMapping("/tenant")
public class TenantController {

    @Autowired
    private TenantService tenantService;

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Tenant tenant, HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        tenant.setUsername(username);
        System.out.println(tenant);
        tenantService.save(tenant);
        return "保存成功";
    }

    @RequestMapping(value = "/findAll",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findAll(@RequestParam("page")String page,@RequestParam("limit")String limit) throws JsonProcessingException{
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Tenant> tenantList = tenantService.findAll((start - 1) * pageSize, pageSize);
        List<Tenant> tenantList2 = tenantService.findAll2();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(tenantList);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+tenantList2.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    @RequestMapping(value = "/findByLocation",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String findByLocation(@RequestParam("location")String location,@RequestParam("page")String page,@RequestParam("limit")String limit) throws JsonProcessingException{
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Tenant> tenantList = tenantService.findByLocation(location);
        PageHelper.startPage(start,pageSize);
        List<Tenant> tenantList2 = tenantService.findByLocation(location);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(tenantList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+tenantList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }
}
