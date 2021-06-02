package com.zzk.service;

import com.zzk.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface ReviewService {

    public void save(Review review);

    public List<Review> findAll();

    public List<Review> findAllMark();

    public void del(String username);


    public void changeMark(String username);

    public List<Review> findByUser(String username);

    List<Review> findAllMarkByUsername(String username);
}
