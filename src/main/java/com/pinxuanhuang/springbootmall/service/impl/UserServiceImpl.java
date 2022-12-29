package com.pinxuanhuang.springbootmall.service.impl;

import com.pinxuanhuang.springbootmall.dao.UserDao;
import com.pinxuanhuang.springbootmall.dto.UserLoginRequest;
import com.pinxuanhuang.springbootmall.dto.UserRegisterRequest;
import com.pinxuanhuang.springbootmall.model.User;
import com.pinxuanhuang.springbootmall.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class UserServiceImpl implements UserService {

    private final static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserDao userDao;

    @Override
    public User login(UserLoginRequest userLoginRequest){
        User user = userDao.getUserByEmail(userLoginRequest.getEmail());
        if(user == null){
            log.warn("{} has not registered yet.", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        if(user.getPassword().equals(userLoginRequest.getPassword())){
            return user;
        } else {
            log.warn("email {}'s password is not correct.", userLoginRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public User getUserById(Integer userId){
        return userDao.getUserById(userId);
    }

    @Override
    public Integer register(UserRegisterRequest userRegisterRequest){
        User user = userDao.getUserByEmail(userRegisterRequest.getEmail());
        // check whether user was existed or not
        if (user != null){
            log.warn("email {} has already existed", userRegisterRequest.getEmail());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        // create a new user
        return userDao.createUser(userRegisterRequest);
    }
}
