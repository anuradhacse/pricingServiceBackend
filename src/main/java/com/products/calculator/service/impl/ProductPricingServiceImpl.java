package com.products.calculator.service.impl;

import com.products.calculator.common.enumeration.QuantityType;
import com.products.calculator.dao.ProductDao;
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
    public ProductPriceResponseDTO calculatePriceByUnits(String productId, int units) {
        //get product details by product id
        Product product = productDao.getProductByProductId(productId);
        //calculate price
        var price = PricingEngine.calculatePrice(product, units, QuantityType.UNIT);

        ProductPriceResponseDTO productPriceDTO = new ProductPriceResponseDTO();
        productPriceDTO.setProductId(productId);
        productPriceDTO.setName(product.getName());
        productPriceDTO.setUnits(units);
        productPriceDTO.setPrice(price);

        return productPriceDTO;
    }

    @Override
    public ProductPriceResponseDTO calculatePriceByCartons(String productId, int cartons) {
        //convert cartons to units
        //call calculating by units service
        return null;
    }
}
