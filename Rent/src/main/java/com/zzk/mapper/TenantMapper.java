package com.zzk.mapper;

import com.zzk.domain.Tenant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenantMapper {
    public void save(Tenant tenant);

    public List<Tenant> findAll2();

    public List<Tenant> findAll(@Param("start")int start,@Param("limit")int limit);

    public List<Tenant> findByLocation(@Param("location")String location);

    public List<Tenant> findByUser(@Param("username")String username);

    public void change(@Param("id")int id,@Param("price")int price);

    public void del(@Param("id")int id);
}
