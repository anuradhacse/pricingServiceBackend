package com.products.calculator.dao;

import com.products.calculator.entity.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao {

    public Product getProductByProductId(String productId);
}
