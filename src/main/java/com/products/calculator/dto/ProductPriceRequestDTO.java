package com.products.calculator.dto;

import com.products.calculator.common.enumeration.QuantityType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductPriceRequestDTO {

    @NotBlank(message = "product id is required")
    private String productId;
    @NotNull(message= "quantity is required")
    private Integer quantity;
    @NotNull(message= "quantity type is required")
    private QuantityType quantityType;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public QuantityType getQuantityType() {
        return quantityType;
    }

    public void setQuantityType(QuantityType quantityType) {
        this.quantityType = quantityType;
    }
}
