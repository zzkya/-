package com.zzk.mapper;

import com.zzk.domain.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentMapper {

    public void save(Rent rent);

    public List<Rent> findAll(@Param("start")int start,@Param("limit")int limit);

    public List<Rent> findByLocation(@Param("location")String location);

    public List<Rent> findByUser(@Param("username")String username);

    public List<Rent> findAll2();

    public void del(@Param("id")int id);

    public void change(@Param("id")int id,@Param("price")int price);

    public void rented(@Param("id")int id,@Param("username")String username);

    public List<Rent> findByMark(@Param("username")String username);
}
