package com.getdev.automotivepartsecommerce.models.payloads.requests;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDetails {
    @NotNull(message = "First Name cannot be null")
    @Size(min = 2, message = "First Name must be more than two characters")
    private String firstName;

    @NotNull(message = "First Name cannot be null")
    @Size(min = 2, message = "First Name must be more than two characters")
    private String lastName;

    @NotNull(message = "Email cannot be null")
    @Email
    private String email;

    @NotNull(message = "Password cannot be null")
    @Size(min = 6, max = 9, message = "Password must be less equal to six or less than 10")
    private String password;

}
