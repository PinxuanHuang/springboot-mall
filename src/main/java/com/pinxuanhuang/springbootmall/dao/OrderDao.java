package com.pinxuanhuang.springbootmall.dao;

import com.pinxuanhuang.springbootmall.model.Order;
import com.pinxuanhuang.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId, Integer totalAmount);
    Order getOrderById(Integer orderId);
    List<OrderItem> getOrderItemsByOrderId(Integer orderId);
    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}
