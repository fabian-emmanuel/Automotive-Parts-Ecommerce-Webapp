package com.getdev.automotivepartsecommerce.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToMany
    //@JsonProperty
    @Column
    private List<Product> products;
    
    @OneToOne(mappedBy = "cart")
    //@JsonProperty
    private UserEntity user;

    @Column
    @JsonProperty
    private BigDecimal total;

    public void addProduct(Product product) {
        if(products == null) {
            products = new ArrayList<>();
        }
        products.add(product);
        if(total == null) {
            total = new BigDecimal(0);
        }
        total = total.add(product.getPrice());
    }

    public void removeProduct(Product product) {
        if(products == null) {
            products = new ArrayList<>();
        }
        products.remove(product);
        if(total == null) {
            total = new BigDecimal(0);
        }
        total = total.subtract(product.getPrice());
    }
}
