package com.getdev.automotivepartsecommerce.models.payloads.requests;

import lombok.Data;

@Data
public class CartRequest {
    private String email;
    private Long productId;
    private int quantity;
}
