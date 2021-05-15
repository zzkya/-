package com.zzk.service;

import com.zzk.domain.Rent;

import java.util.List;

public interface RentService {

    public void save(Rent rent);

    public List<Rent> findAll();
}
