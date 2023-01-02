package com.pinxuanhuang.springbootmall.service.impl;

import com.pinxuanhuang.springbootmall.dao.OrderDao;
import com.pinxuanhuang.springbootmall.dao.ProductDao;
import com.pinxuanhuang.springbootmall.dto.BuyItem;
import com.pinxuanhuang.springbootmall.dto.CreateOrderRequest;
import com.pinxuanhuang.springbootmall.model.OrderItem;
import com.pinxuanhuang.springbootmall.model.Product;
import com.pinxuanhuang.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest){
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());
            System.out.println("getProductIdFromDao : " + product.getProductId());
            // calculate totalAmount
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // convert BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }


        // create order
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        System.out.println("orderId : " + orderId);
        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }
}
