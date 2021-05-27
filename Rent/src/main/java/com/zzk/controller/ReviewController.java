package com.zzk.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.zzk.domain.Rent;
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
        review.setMark(0);
        List<Review> byUser = reviewService.findByUser(username);
        //System.out.println(byUser);
        if(byUser.size()!=0) return "0";
        reviewService.save(review);
        //System.out.println(byUser);
        return "1";
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public String findAll(@RequestParam("page")String page,@RequestParam("limit")String limit) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Review> reviewList,reviewList2;
        reviewList = reviewService.findAll();
        PageHelper.startPage(start,pageSize);
        reviewList2 = reviewService.findAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(reviewList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+reviewList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    @RequestMapping("/findAllMark")
    @ResponseBody
    public String findAllMark(@RequestParam("page")String page,@RequestParam("limit")String limit) throws JsonProcessingException {
        int start=Integer.parseInt(page);
        int pageSize=Integer.parseInt(limit);
        List<Review> reviewList,reviewList2;
        reviewList = reviewService.findAllMark();
        PageHelper.startPage(start,pageSize);
        reviewList2 = reviewService.findAllMark();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(reviewList2);
        String books="{\"code\":0,\"msg\":\"ok\",\"count\":"+reviewList.size()+",\"data\":"+json+"}";
        System.out.println(books);
        return books;
    }

    @RequestMapping("/delNo")
    @ResponseBody
    public void delN(@RequestParam("username") String username){
        reviewService.del(username);
    }

    @RequestMapping("/changeMark")
    @ResponseBody
    public void changeMark(@RequestParam("username") String username){
        reviewService.changeMark(username);
        userService.changeAuth(3,username);
    }

}
