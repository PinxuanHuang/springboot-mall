package com.pinxuanhuang.springbootmall.service;

import com.pinxuanhuang.springbootmall.dto.UserRegisterRequest;
import com.pinxuanhuang.springbootmall.model.User;

public interface UserService {

    User getUserById(Integer userId);
    Integer register(UserRegisterRequest userRegisterRequest);
}
