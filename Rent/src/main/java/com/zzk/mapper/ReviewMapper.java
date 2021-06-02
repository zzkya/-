package com.zzk.mapper;

import com.zzk.domain.Review;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReviewMapper {
    public void save(Review review);

    public List<Review> findAll();

    public List<Review> findAllMark();

    public List<Review> findAllRent();

    public List<Review> findByUser(@Param("username")String username);

    public void del(@Param("username")String username);

    public void changeMark(@Param("username")String username);

    List<Review> findAllMarkByUsername(@Param("username")String username);
}
