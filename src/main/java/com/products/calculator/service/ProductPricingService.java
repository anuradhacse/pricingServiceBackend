package com.products.calculator.service;

import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.dto.ProductPriceResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ProductPricingService {

    public ProductPriceResponseDTO calculatePriceByUnits(ProductPriceRequestDTO request);

}
