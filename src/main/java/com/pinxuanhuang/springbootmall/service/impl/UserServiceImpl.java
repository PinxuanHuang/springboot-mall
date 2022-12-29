package com.pinxuanhuang.springbootmall.service.impl;

import com.pinxuanhuang.springbootmall.dao.UserDao;
import com.pinxuanhuang.springbootmall.dto.UserRegisterRequest;
import com.pinxuanhuang.springbootmall.model.User;
import com.pinxuanhuang.springbootmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getUserById(Integer userId){
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest){
        return userDao.createUser(userRegisterRequest);
    }
}
