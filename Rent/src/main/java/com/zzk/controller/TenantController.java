package com.zzk.controller;

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

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Tenant> tenantList = tenantService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tenantList",tenantList);
        modelAndView.setViewName("tenantList");
        return modelAndView;
    }

    @RequestMapping("/findByLocation")
    public ModelAndView findByLocation(@RequestParam("location")  String location){
        List<Tenant> tenantList = tenantService.findByLocation(location);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("tenantList",tenantList);
        modelAndView.setViewName("tenantList");
        return modelAndView;
    }
}
