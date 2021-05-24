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
    public List<Tenant> findAll() {
        return tenantMapper.findAll();
    }

    @Override
    public List<Tenant> findByLocation(String location) {
        return tenantMapper.findByLocation(location);
    }
}
