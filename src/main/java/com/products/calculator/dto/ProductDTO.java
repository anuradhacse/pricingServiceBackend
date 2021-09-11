package com.products.calculator.dto;

import com.products.calculator.entity.Product;

public class ProductDTO {

    private String id;
    private String name;

    public ProductDTO(){

    }
    public ProductDTO(Product product){
        this.id = product.getId();
        this.name = product.getName();
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
}
