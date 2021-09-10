package com.products.calculator.entity;

import java.math.BigDecimal;

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
}
