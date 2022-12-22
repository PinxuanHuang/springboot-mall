package com.pinxuanhuang.springbootmall.service;

import com.pinxuanhuang.springbootmall.dto.ProductRequest;
import com.pinxuanhuang.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    Integer createProduct(ProductRequest productRequest);
    void updateProduct(Integer productId, ProductRequest productRequest);

}
