package com.zzk.service;

import com.zzk.domain.Tenant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenantService {
    public void save(Tenant tenant);

    public List<Tenant> findAll();

    public List<Tenant> findByLocation(String location);
}
