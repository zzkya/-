package com.zzk.service;

import com.zzk.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ReviewService {

    public void save(Review review);

    public List<Review> findAll();

    public void del(String username);

}
