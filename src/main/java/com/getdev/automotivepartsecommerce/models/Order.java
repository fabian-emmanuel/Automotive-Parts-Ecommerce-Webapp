package com.getdev.automotivepartsecommerce.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
@RequiredArgsConstructor
@Getter
@Setter
public class Order {
    @Id @GeneratedValue()
    private Long id;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false, referencedColumnName = "id")
    //@JsonProperty
    private UserEntity user;

    @ManyToMany(cascade = CascadeType.ALL)
    //@JsonProperty
    @Column
    private List<Product> products;

    //@JsonProperty
    @Column
    private BigDecimal total;


    public static Order createFromCart(Cart cart) {
        Order order = new Order();
        order.setProducts(new ArrayList<>(cart.getProducts()));
        order.setTotal(cart.getTotal());
        order.setUser(cart.getUser());
        return order;
    }
}
