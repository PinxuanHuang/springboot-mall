package com.pinxuanhuang.springbootmall.service;

import com.pinxuanhuang.springbootmall.dto.CreateOrderRequest;
import com.pinxuanhuang.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
    Order getOrderById(Integer orderId);
}
