package com.zzk.service;

import com.zzk.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserService {

    public void save(User user);

    public User ifExist(String username, String password);

    public User ifUser(String username);

    public void changeAuth(int auth,String username);

    public void change(User user);
}
