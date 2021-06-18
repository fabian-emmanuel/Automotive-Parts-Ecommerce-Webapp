package com.getdev.automotivepartsecommerce.controllers;

import com.getdev.automotivepartsecommerce.payStackIntegration.InitializeTransactionRequest;
import com.getdev.automotivepartsecommerce.payloads.response.HttpResponse;
import com.getdev.automotivepartsecommerce.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/redirect")
    public void makePayment(HttpServletResponse httpServletResponse) throws Exception {

        InitializeTransactionRequest request = new InitializeTransactionRequest();

        //get payment url
        String paymentUrl = paymentService.getPaymentAuthorizationUrl(request);

        httpServletResponse.setHeader("Location", paymentUrl);
        httpServletResponse.setStatus(302);
    }

    @PostMapping( "/confirm/{orderId}")
    public ResponseEntity<HttpResponse> confirmPayment(@PathVariable int orderId) throws Exception {
        return paymentService.confirmPayment(orderId);
    }
}
