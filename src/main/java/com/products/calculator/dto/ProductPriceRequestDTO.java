package com.products.calculator.dto;

import com.products.calculator.common.enumeration.QuantityType;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * API bean for representing product price request
 */
public class ProductPriceRequestDTO implements Serializable {

    private static final long serialVersionUID = -1868728525369922867L;

    @NotBlank(message = "product id is required")
    private String productId;
    @NotNull(message= "quantity is required")
    @Min(value = 1, message = "quantity should be greater than 0")
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

    @Override
    public String toString() {
        return "ProductPriceRequestDTO{" +
                "productId='" + productId + '\'' +
                ", quantity=" + quantity +
                ", quantityType=" + quantityType +
                '}';
    }
}
