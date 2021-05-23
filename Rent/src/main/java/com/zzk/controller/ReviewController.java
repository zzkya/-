package com.zzk.controller;

import com.zzk.domain.Review;
import com.zzk.service.ReviewService;
import com.zzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Review review, HttpSession httpSession){
        String username = (String) httpSession.getAttribute("username");
        review.setUsername(username);
        //System.out.println(review);
        reviewService.save(review);
        return "保存成功";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        List<Review> reviewList = reviewService.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("reviewList",reviewList);
        modelAndView.setViewName("reviewList");
        return modelAndView;
    }

    @RequestMapping("/del")
    public void del(@RequestParam("username") String username){
        reviewService.del(username);
        userService.changeAuth(3,username);
    }

}
