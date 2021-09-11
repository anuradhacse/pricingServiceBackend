package com.products.calculator.controller;

import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.dto.ProductPriceResponseDTO;
import com.products.calculator.service.ProductPricingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products/pricing")
public class ProductPricingController {

    private static final Logger log = LoggerFactory.getLogger(ProductPricingController.class);

    @Autowired
    private ProductPricingService productPricingService;

    @GetMapping("/calculate")
    public ProductPriceResponseDTO calculateByUnits(@RequestBody ProductPriceRequestDTO request){
        log.info("Request received to calculate price for : product {}, quantity {}, quantityType {}",
                request.getProductId(), request.getQuantity(), request.getQuantityType());
        return productPricingService.calculatePriceByUnits(request);
    }

    @GetMapping("/list")
    public List<ProductPriceResponseDTO> getProductPriceList(){
        return List.of();
    }
}
