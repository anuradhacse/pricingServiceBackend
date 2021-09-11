package com.products.calculator.controller;

import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.dto.ProductPriceResponseDTO;
import com.products.calculator.service.ProductPricingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path ="/products/pricing", produces = "application/json", consumes = "application/json")
@CrossOrigin(origins="*")
public class ProductPricingController {

    private static final Logger log = LoggerFactory.getLogger(ProductPricingController.class);

    @Autowired
    private ProductPricingService productPricingService;

    @PostMapping("/calculate")
    public ProductPriceResponseDTO calculateByUnits(@Valid @RequestBody ProductPriceRequestDTO request){
        log.info("Request received to calculate price for : product {}, quantity {}, quantityType {}",
                request.getProductId(), request.getQuantity(), request.getQuantityType());
        return productPricingService.calculatePriceByUnits(request);
    }

    @GetMapping("/list")
    public List<ProductPriceResponseDTO> getProductPriceList(){
        log.info("Request received to get product price list 1-50 units");
        return productPricingService.getProductPriceList();
    }
}
