package com.getdev.automotivepartsecommerce.models.payloads.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
