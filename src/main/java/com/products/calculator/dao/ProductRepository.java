package com.products.calculator.dao;

import com.products.calculator.common.exeception.ProductNotFoundException;
import com.products.calculator.entity.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository()
public class ProductRepository {

    private static List<Product> productList = List.of(
            new Product("1", "Penguin-ears", 20, BigDecimal.valueOf(175)),
            new Product("2", "Horseshoe", 5, BigDecimal.valueOf(825))
    );

    public Product getProductByProductId(String productId) {
        Optional<Product> product = productList.stream().filter((Product p) -> p.getId().equals(productId)).findAny();
        if(product.isPresent()){
            return product.get();
        }
        throw new ProductNotFoundException("Cannot find the product with the given ID - " + productId);
    }

    public List<Product> getAllProducts(){
        return productList;
    }
}
