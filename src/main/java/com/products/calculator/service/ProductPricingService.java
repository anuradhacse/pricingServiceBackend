package com.products.calculator.service;

import com.products.calculator.common.enumeration.QuantityType;
import com.products.calculator.controller.ProductPricingController;
import com.products.calculator.dao.ProductRepository;
import com.products.calculator.dto.ProductPriceRequestDTO;
import com.products.calculator.dto.ProductPriceResponseDTO;
import com.products.calculator.entity.Product;
import com.products.calculator.util.PricingEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductPricingService {

    private static final Logger log = LoggerFactory.getLogger(ProductPricingService.class);

    @Autowired
    private ProductRepository productDao;

    public ProductPriceResponseDTO calculatePriceByUnits(ProductPriceRequestDTO request) {
        log.info("Started calculating price for : product {}, quantity {}, quantityType {}",
                request.getProductId(), request.getQuantity(), request.getQuantityType());

        var product = productDao.getProductByProductId(request.getProductId());
        var price = PricingEngine.calculatePrice(product, request.getQuantity(), request.getQuantityType());
        log.info("Successfully Calculated. price : {}", price);

        var productPriceDTO = new ProductPriceResponseDTO();
        productPriceDTO.setProductId(product.getId());
        productPriceDTO.setName(product.getName());
        productPriceDTO.setUnits(request.getQuantity());
        productPriceDTO.setPrice(price);

        return productPriceDTO;
    }

    public List<ProductPriceResponseDTO> getProductPriceList(){
        log.info("Started generating product price list");

        List<ProductPriceResponseDTO> response = new ArrayList<>();

        var requestForPenguinEars50Units = new ProductPriceRequestDTO();
        requestForPenguinEars50Units.setProductId("1");
        requestForPenguinEars50Units.setQuantityType(QuantityType.UNIT);

        for(int i=1; i<=50; ++i){
            requestForPenguinEars50Units.setQuantity(i);
            response.add(calculatePriceByUnits(requestForPenguinEars50Units));
        }

        var requestForHorseShoe50Units = new ProductPriceRequestDTO();
        requestForHorseShoe50Units.setProductId("2");
        requestForHorseShoe50Units.setQuantityType(QuantityType.UNIT);

        for(int i=1; i<=50; ++i){
            requestForHorseShoe50Units.setQuantity(i);
            response.add(calculatePriceByUnits(requestForHorseShoe50Units));
        }

        log.info("Completed generating product price list. total calculations : {}",
                response.size());

        return response;
    }
}
