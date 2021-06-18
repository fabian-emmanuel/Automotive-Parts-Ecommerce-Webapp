package com.getdev.automotivepartsecommerce.models;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name="payment")
public class Payment {
    @Id @GeneratedValue
    private Long id;

    @Column(name = "payment_ref")
    private String paymentReference;

    @Column(name = "order_id")
    private int orderId;

    @Column(name = "confirm_payment")
    private boolean confirmPayment;

}
