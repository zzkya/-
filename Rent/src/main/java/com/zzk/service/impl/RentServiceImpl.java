package com.zzk.service.impl;

import com.zzk.domain.Rent;
import com.zzk.mapper.RentMapper;
import com.zzk.service.RentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rentService")
public class RentServiceImpl implements RentService {

    @Autowired
    private RentMapper rentMapper;

    @Override
    public void save(Rent rent) {
        rentMapper.save(rent);
    }

    @Override
    public List<Rent> findAll(int start,int limit) {
        return rentMapper.findAll(start,limit);
    }

    @Override
    public List<Rent> findByLocation(String location) {
        return rentMapper.findByLocation(location);
    }
}
