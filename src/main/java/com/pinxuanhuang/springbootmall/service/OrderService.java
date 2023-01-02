package com.pinxuanhuang.springbootmall.service;

import com.pinxuanhuang.springbootmall.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
