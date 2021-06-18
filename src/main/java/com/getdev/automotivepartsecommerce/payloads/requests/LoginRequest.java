package com.getdev.automotivepartsecommerce.payloads.requests;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
