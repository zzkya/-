package com.zzk.service.impl;

import com.zzk.domain.User;
import com.zzk.mapper.UserMapper;
import com.zzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void save(User user) {
        userMapper.save(user);
    }

    @Override
    public User ifExist(String username, String password) {
        return userMapper.ifExist(username,password);
    }

    @Override
    public User ifUser(String username) {
        return userMapper.ifUser(username);
    }
}
