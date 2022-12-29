package com.pinxuanhuang.springbootmall.dao;

import com.pinxuanhuang.springbootmall.dto.UserRegisterRequest;
import com.pinxuanhuang.springbootmall.model.User;

public interface UserDao {
    User getUserByEmail(String email);
    User getUserById(Integer userId);
    Integer createUser(UserRegisterRequest userRegisterRequest);
}
