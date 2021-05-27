package com.zzk.service;

import com.zzk.domain.Rent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RentService {

    public void save(Rent rent);

    public List<Rent> findAll(int start,int limit);

    public List<Rent> findAll2();

    public List<Rent> findByLocation(String location);

    public List<Rent> findByUser(String username);

    public void del(int id);

    public void change(int id,int price);

    public void rented(int id,String username);

    public List<Rent> findByMark(String username);
}
