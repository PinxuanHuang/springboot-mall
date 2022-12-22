package com.pinxuanhuang.springbootmall.dao;

import com.pinxuanhuang.springbootmall.dto.ProductRequest;
import com.pinxuanhuang.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
}
