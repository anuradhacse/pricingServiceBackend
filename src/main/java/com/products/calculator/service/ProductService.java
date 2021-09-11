package com.products.calculator.service;

import com.products.calculator.dao.ProductRepository;
import com.products.calculator.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<ProductDTO> getAllProducts() {
        return ProductRepository.getAllProducts()
                .stream()
                .map(ProductDTO::new)
                .collect(Collectors.toList());
    }
}
