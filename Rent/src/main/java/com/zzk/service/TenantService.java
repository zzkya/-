package com.zzk.service;

import com.zzk.domain.Tenant;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TenantService {
    public void save(Tenant tenant);

    public List<Tenant> findAll(int start, int limit);

    public List<Tenant> findAll2();

    public List<Tenant> findByLocation(String location);

    public List<Tenant> findByUser(String username);
}
