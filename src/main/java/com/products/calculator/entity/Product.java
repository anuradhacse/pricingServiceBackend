package com.products.calculator.entity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.math.BigDecimal;

/**
 * Represent a product Entity
 */
public class Product {

    private String id;
    private String name;
    private int unitsPerCarton;
    private BigDecimal cartonPrice;

    public Product(String id, String name, int unitsPerCarton, BigDecimal cartonPrice) {
        this.id = id;
        this.name = name;
        this.unitsPerCarton = unitsPerCarton;
        this.cartonPrice = cartonPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitsPerCarton() {
        return unitsPerCarton;
    }

    public void setUnitsPerCarton(int unitsPerCarton) {
        this.unitsPerCarton = unitsPerCarton;
    }

    public BigDecimal getCartonPrice() {
        return cartonPrice;
    }

    public void setCartonPrice(BigDecimal cartonPrice) {
        this.cartonPrice = cartonPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        return new EqualsBuilder().append(unitsPerCarton, product.unitsPerCarton).append(id, product.id).append(name, product.name).append(cartonPrice, product.cartonPrice).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).append(unitsPerCarton).append(cartonPrice).toHashCode();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", unitsPerCarton=" + unitsPerCarton +
                ", cartonPrice=" + cartonPrice +
                '}';
    }
}
