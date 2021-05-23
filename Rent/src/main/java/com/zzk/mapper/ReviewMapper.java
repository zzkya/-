package com.zzk.mapper;

import com.zzk.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewMapper {
    public void save(Review review);

    public List<Review> findAll();

    public void del(@Param("username")String username);
}
