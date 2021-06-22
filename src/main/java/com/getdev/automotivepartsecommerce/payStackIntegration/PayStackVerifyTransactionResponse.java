package com.getdev.automotivepartsecommerce.payStackIntegration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;
import lombok.ToString;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.core.env.Environment;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@ToString
@Setter
public class PayStackVerifyTransactionResponse extends VerifyTransactionResponse {
    private static Environment environment;

    public PayStackVerifyTransactionResponse verifyTransaction(String reference) throws Exception {

        PayStackVerifyTransactionResponse payStackResponse;

        try {

            HttpClient client = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://api.paystack.co/transaction/verify/" + reference);
            request.addHeader("Content-type", "application/json");
            request.addHeader("Authorization", "Bearer sk_test_c50358f944856001a866ae90a236f747064e2ee2");

            StringBuilder result = new StringBuilder();

            HttpResponse response = client.execute(request);

            if (response.getStatusLine().getStatusCode() == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

            } else {
                throw new Exception("Error Occurred while connecting to pay-stack url");
            }

            ObjectMapper mapper = new ObjectMapper();

            try {
                payStackResponse = mapper.readValue(result.toString(), PayStackVerifyTransactionResponse.class);

                if (payStackResponse.getPayStackData().getStatus().equals("success"))
                    System.out.println("Payment successfully made");

            } catch (JsonProcessingException e) {
                System.out.println("You've already made payment or An error occurred while verifying payment ");
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new Exception("Internal server error");
        }

        return payStackResponse;
    }
}
