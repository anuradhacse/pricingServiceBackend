package com.products.calculator.controller;

import com.products.calculator.dto.ProductDTO;
import com.products.calculator.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products", produces = "application/json")
@CrossOrigin(origins="*")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductDTO> getProducts() {
        log.info("Request received to get product list");
        return productService.getAllProducts();
    }
}
