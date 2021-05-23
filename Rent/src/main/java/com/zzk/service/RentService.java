package com.zzk.service;

import com.zzk.domain.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentService {

    public void save(Rent rent);

    public List<Rent> findAll();

    public List<Rent> findByLocation(String location);
}
