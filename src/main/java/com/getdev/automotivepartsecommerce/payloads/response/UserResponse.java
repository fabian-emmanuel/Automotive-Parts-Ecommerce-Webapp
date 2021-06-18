package com.getdev.automotivepartsecommerce.payloads.response;

import lombok.Data;

@Data
public class UserResponse {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
}
