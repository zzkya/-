package com.zzk.service.impl;

import com.zzk.domain.Review;
import com.zzk.mapper.ReviewMapper;
import com.zzk.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("reviewService")
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewMapper reviewMapper;

    @Override
    public void save(Review review) {
        reviewMapper.save(review);
    }

    @Override
    public List<Review> findAll() {
        return reviewMapper.findAll();
    }


    @Override
    public List<Review> findAllMark() {
        return reviewMapper.findAllMark();
    }

    @Override
    public void del(String username) {
        reviewMapper.del(username);
    }

    @Override
    public void changeMark(String username) {
        reviewMapper.changeMark(username);
    }

    @Override
    public List<Review> findByUser(String username) {
        return reviewMapper.findByUser(username);
    }

    @Override
    public List<Review> findAllMarkByUsername(String username) {
        return reviewMapper.findAllMarkByUsername(username);
    }
}
