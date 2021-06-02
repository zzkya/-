package com.zzk.service.impl;

import com.zzk.domain.User;
import com.zzk.mapper.UserMapper;
import com.zzk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public void changeAuth(int auth, String username) {
        userMapper.changeAuth(auth,username);
    }


    @Override
    public void change(User user) {
        userMapper.change(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }
}
