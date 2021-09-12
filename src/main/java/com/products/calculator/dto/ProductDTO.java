package com.products.calculator.dto;

import com.products.calculator.entity.Product;

import java.io.Serializable;

/**
 * API bean for representing a product entity
 */
public class ProductDTO implements Serializable {

    private static final long serialVersionUID = -789080277939731604L;

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

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
