package com.products.calculator.service;

import com.products.calculator.dao.ProductRepository;
import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.dto.ProductPriceResponseDTO;
import com.products.calculator.entity.Product;
import com.products.calculator.util.PricingEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPricingService {

    @Autowired
    private ProductRepository productDao;

    public ProductPriceResponseDTO calculatePriceByUnits(ProductPriceRequestDTO request) {
        //get product details by product id
        Product product = productDao.getProductByProductId(request.getProductId());
        //calculate price
        var price = PricingEngine.calculatePrice(product, request.getQuantity(), request.getQuantityType());

        ProductPriceResponseDTO productPriceDTO = new ProductPriceResponseDTO();
        productPriceDTO.setProductId(product.getId());
        productPriceDTO.setName(product.getName());
        productPriceDTO.setUnits(request.getQuantity());
        productPriceDTO.setPrice(price);

        return productPriceDTO;
    }
}
