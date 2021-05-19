package com.zzk.service;

import com.zzk.domain.User;

public interface UserService {

    public void save(User user);

    public boolean ifExist(User user);
}
