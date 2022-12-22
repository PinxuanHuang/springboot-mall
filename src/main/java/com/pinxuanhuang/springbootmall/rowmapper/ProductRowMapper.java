package com.pinxuanhuang.springbootmall.rowmapper;

import com.pinxuanhuang.springbootmall.constant.ProductCategory;
import com.pinxuanhuang.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductRowMapper implements RowMapper {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        Product product = new Product();
        String categoryStr = resultSet.getString("category");
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setProductId(resultSet.getInt("product_id"));
        product.setProductName(resultSet.getString("product_name"));
        product.setCategory(category);
        product.setImageUrl(resultSet.getString("Image_url"));
        product.setPrice(resultSet.getInt("price"));
        product.setStock(resultSet.getInt("stock"));
        product.setDescription(resultSet.getString("description"));
        product.setCreatedDate(resultSet.getTimestamp("create_date"));
        product.setLastModifiedDate(resultSet.getTimestamp("last_modified_date"));
        return product;
    }
}