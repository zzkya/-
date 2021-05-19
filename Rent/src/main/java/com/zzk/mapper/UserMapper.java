package com.zzk.mapper;

import com.zzk.domain.Rent;
import com.zzk.domain.User;

public interface UserMapper {
    public void save(User rent);

    public boolean ifExist(User rent);
}
