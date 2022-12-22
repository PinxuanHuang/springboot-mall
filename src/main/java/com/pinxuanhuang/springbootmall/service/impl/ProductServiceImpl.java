package com.pinxuanhuang.springbootmall.service.impl;

import com.pinxuanhuang.springbootmall.dao.ProductDao;
import com.pinxuanhuang.springbootmall.dto.ProductRequest;
import com.pinxuanhuang.springbootmall.model.Product;
import com.pinxuanhuang.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId){
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest){
        return productDao.createProduct(productRequest);
    }
}
