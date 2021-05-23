package com.zzk.mapper;

import com.zzk.domain.Rent;
import com.zzk.domain.Tenant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenantMapper {
    public void save(Tenant tenant);

    public List<Tenant> findAll();

    public List<Tenant> findByLocation(@Param("location")String location);
}
