package com.products.calculator.dto;

import com.products.calculator.entity.Product;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

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
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProductDTO that = (ProductDTO) o;

        return new EqualsBuilder().append(id, that.id).append(name, that.name).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(name).toHashCode();
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
