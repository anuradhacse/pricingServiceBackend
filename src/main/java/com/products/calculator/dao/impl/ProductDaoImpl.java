package com.products.calculator.dao.impl;

import com.products.calculator.common.exeception.ProductServiceException;
import com.products.calculator.dao.ProductDao;
import com.products.calculator.entity.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {

    private static List<Product> productList = List.of(
            new Product("1", "Penguin-ears", 20, new BigDecimal(175)),
            new Product("2", "Horseshoe", 5, new BigDecimal(825))
    );

    @Override
    public Product getProductByProductId(String productId) {
        Optional<Product> product = productList.stream().filter((Product p) -> p.getId().equals(productId)).findAny();
        if(product.isPresent()){
            return product.get();
        }
        throw new ProductServiceException("Cannot find the product with the given ID - " + productId);
    }
}
