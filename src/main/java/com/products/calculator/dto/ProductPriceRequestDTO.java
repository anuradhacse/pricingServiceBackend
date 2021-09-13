package com.products.calculator.dto;

import com.products.calculator.common.enumeration.QuantityType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductPriceRequestDTO that = (ProductPriceRequestDTO) o;

        return new EqualsBuilder().append(productId, that.productId).append(quantity, that.quantity).append(quantityType, that.quantityType).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(productId).append(quantity).append(quantityType).toHashCode();
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
