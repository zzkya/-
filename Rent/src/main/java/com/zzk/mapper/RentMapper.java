package com.zzk.mapper;

import com.zzk.domain.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentMapper {

    public void save(Rent rent);

    public List<Rent> findAll();

    public List<Rent> findByLocation(@Param("location")String location);
}
