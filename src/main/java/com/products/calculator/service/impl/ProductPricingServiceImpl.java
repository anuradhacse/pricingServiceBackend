package com.products.calculator.service.impl;

import com.products.calculator.common.enumeration.QuantityType;
import com.products.calculator.dao.ProductDao;
import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.dto.ProductPriceResponseDTO;
import com.products.calculator.entity.Product;
import com.products.calculator.service.ProductPricingService;
import com.products.calculator.util.PricingEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductPricingServiceImpl implements ProductPricingService {

    @Autowired
    private ProductDao productDao;

    @Override
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
