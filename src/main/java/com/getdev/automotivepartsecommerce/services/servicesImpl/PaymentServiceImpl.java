package com.getdev.automotivepartsecommerce.services.servicesImpl;

import com.getdev.automotivepartsecommerce.models.Payment;
import com.getdev.automotivepartsecommerce.payStackIntegration.InitializeTransaction;
import com.getdev.automotivepartsecommerce.payStackIntegration.InitializeTransactionRequest;
import com.getdev.automotivepartsecommerce.payStackIntegration.InitializeTransactionResponse;
import com.getdev.automotivepartsecommerce.payStackIntegration.PayStackVerifyTransactionResponse;
import com.getdev.automotivepartsecommerce.payloads.response.HttpResponse;
import com.getdev.automotivepartsecommerce.repositories.PaymentRepo;
import com.getdev.automotivepartsecommerce.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepo paymentRepo;


    @Override
    public String getPaymentAuthorizationUrl(InitializeTransactionRequest request) {
        request.setEmail("test@test.com");

        //conversion from Kobo to Naira
        request.setAmount(3500*100);
//        request.setCallBackUrl("http://localhost/api/payment/confirm");

        System.err.println("Reached here***************");
        InitializeTransactionResponse res = InitializeTransaction.initTransaction(request);

        String authorizationUrl = res.getData().getAuthorization_url();

        if (!res.getStatus()) return null;

        try{
        //save it in the database to check later if user has made payment;
        Payment payment = new Payment();

        int size = paymentRepo.findAll().size();

        payment.setOrderId(size + 1);
        payment.setConfirmPayment(false);
        payment.setPaymentReference(res.getData().getReference());

        paymentRepo.save(payment);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return authorizationUrl;
    }

    @Override
    public ResponseEntity<HttpResponse> confirmPayment(int orderId) throws Exception {
        HttpResponse res = new HttpResponse();

        Optional<Payment> paymentOptional = paymentRepo.findPaymentByOrderId(orderId);

        if(paymentOptional.isEmpty()) {
            res.setStatus(404);
            res.setMessage("Order Not Found!");

            return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
        }

        //payment reference
        String paymentReference = paymentOptional.get().getPaymentReference();

        PayStackVerifyTransactionResponse payStackVerifyTransactionResponse = new PayStackVerifyTransactionResponse();
        payStackVerifyTransactionResponse = payStackVerifyTransactionResponse.verifyTransaction(paymentReference);

        if(payStackVerifyTransactionResponse==null){
            paymentOptional.get().setConfirmPayment(true);
            paymentRepo.save(paymentOptional.get());

            res.setStatus(201);
            res.setMessage("Payment already made on this order");

        }else{

            if (!payStackVerifyTransactionResponse.getPayStackData().getStatus().equals("success")){
                res.setStatus(200);
                res.setMessage("Payment has not been made yet on this order");

                return new ResponseEntity<>(res, HttpStatus.OK);
            }
        }

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
}
