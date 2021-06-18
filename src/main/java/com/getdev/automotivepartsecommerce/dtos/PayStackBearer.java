package com.getdev.automotivepartsecommerce.dtos;

import lombok.Data;
import lombok.RequiredArgsConstructor;

public class PayStackBearer {
    public static Account account;


    @RequiredArgsConstructor
    @Data
    public static class Account {
        private String name;
        private String accountNumber;
        private String cvv;
        private String issuer;
        private String cardNumber;
        private String expiryMonth;
        private String expiryYear;
        private String country;
        private String zipcode;
    }
}
