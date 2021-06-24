package com.getdev.automotivepartsecommerce.services;

import com.getdev.automotivepartsecommerce.configurations.payStackIntegration.InitializeTransactionRequest;
import com.getdev.automotivepartsecommerce.payloads.response.HttpResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    String getPaymentAuthorizationUrl(InitializeTransactionRequest request) throws Exception;

    ResponseEntity<HttpResponse> confirmPayment(int orderId) throws Exception;
}
