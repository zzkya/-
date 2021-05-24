package com.zzk.mapper;

import com.zzk.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    public void save(User user);

    public User ifExist(@Param("username")String username, @Param("password")String password);

    public User ifUser(@Param("username")String username);

    public void changeAuth(@Param("auth")int auth,@Param("username")String username);

    public void change(User user);
}
