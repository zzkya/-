package com.zzk.service.impl.impl;

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
    public void del(String username) {
        reviewMapper.del(username);
    }
}
