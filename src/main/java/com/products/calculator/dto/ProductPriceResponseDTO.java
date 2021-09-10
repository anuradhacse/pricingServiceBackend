package com.products.calculator.dto;

import java.math.BigDecimal;

public class ProductPriceResponseDTO {

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
    public String toString() {
        return "ProductUnitPrice{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", units=" + units +
                ", price=" + price +
                '}';
    }
}
