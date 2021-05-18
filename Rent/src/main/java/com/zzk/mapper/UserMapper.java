package com.zzk.mapper;

import com.zzk.domain.Rent;

public interface UserMapper {
    public void save(Rent rent);

    public boolean ifExist(Rent rent);
}
