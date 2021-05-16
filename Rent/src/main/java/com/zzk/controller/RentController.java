package com.zzk.controller;


import com.zzk.domain.Rent;
import com.zzk.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/rent")
public class RentController {

    @Autowired
    private RentService rentService;

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Rent account){
        rentService.save(account);
        return "保存成功";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Rent> rentList = rentService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("rentList",rentList);
        modelAndView.setViewName("rentList");
        return modelAndView;
    }
}
