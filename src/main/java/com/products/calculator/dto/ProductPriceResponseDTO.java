package com.products.calculator.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * API bean for representing Product price response
 */
public class ProductPriceResponseDTO implements Serializable {

    private static final long serialVersionUID = -5968705440168269735L;

    private String productId;
    private String name;
    private int units;
    private BigDecimal price;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductPriceResponseDTO that = (ProductPriceResponseDTO) o;

        return new EqualsBuilder().append(units, that.units).append(productId, that.productId).append(name, that.name).append(price, that.price).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(productId).append(name).append(units).append(price).toHashCode();
    }

    @Override
    public String toString() {
        return "ProductUnitPrice{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", units=" + units +
                ", price=" + price +
                '}';
    }
}
