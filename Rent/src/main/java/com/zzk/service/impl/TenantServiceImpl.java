package com.zzk.service.impl;

import com.zzk.domain.Tenant;
import com.zzk.mapper.TenantMapper;
import com.zzk.service.TenantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("tenantService")
public class TenantServiceImpl implements TenantService {

    @Autowired
    TenantMapper tenantMapper;

    @Override
    public void save(Tenant tenant) {
        tenantMapper.save(tenant);
    }

    @Override
    public List<Tenant> findAll(int start, int limit) {
        return tenantMapper.findAll(start,limit);
    }

    @Override
    public List<Tenant> findAll2() {
        return tenantMapper.findAll2();
    }


    @Override
    public List<Tenant> findByLocation(String location) {
        return tenantMapper.findByLocation(location);
    }

    @Override
    public List<Tenant> findByUser(String username) {
        return tenantMapper.findByUser(username);
    }
}
