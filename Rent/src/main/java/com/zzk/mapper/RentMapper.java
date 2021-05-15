package com.zzk.mapper;

import com.zzk.domain.Rent;

import java.util.List;

public interface RentMapper {

    public void save(Rent rent);

    public List<Rent> findAll();
}
