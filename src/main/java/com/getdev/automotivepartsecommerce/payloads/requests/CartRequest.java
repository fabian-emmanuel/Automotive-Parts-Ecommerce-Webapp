package com.getdev.automotivepartsecommerce.payloads.requests;

import lombok.Data;

@Data
public class CartRequest {
    private String email;
    private Long productId;
    private int quantity;
}
