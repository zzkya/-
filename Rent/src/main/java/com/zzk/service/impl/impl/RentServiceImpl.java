package com.zzk.service.impl.impl;

import com.zzk.domain.Rent;
import com.zzk.mapper.RentMapper;
import com.zzk.service.RentService;
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
    public List<Rent> findAll() {
        return rentMapper.findAll();
    }

    @Override
    public List<Rent> findByLocation(String location) {
        return rentMapper.findByLocation(location);
    }
}
