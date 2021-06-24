package com.getdev.automotivepartsecommerce.configurations.payStackIntegration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class InitializeTransaction {


    public static InitializeTransactionResponse initTransaction(InitializeTransactionRequest request) {
        InitializeTransactionResponse initializeTransactionResponse = null;

        try {

            Gson gson = new Gson();

            StringEntity postingString = new StringEntity(gson.toJson(request));

            CloseableHttpClient client = HttpClientBuilder.create().build();

            HttpPost post = new HttpPost("https://api.paystack.co/transaction/initialize");
            post.setEntity(postingString);
            post.addHeader("Content-type", "application/json");
            post.addHeader("Authorization", "Bearer sk_test_c50358f944856001a866ae90a236f747064e2ee2");

            StringBuilder result = new StringBuilder();
            HttpResponse response = client.execute(post);

            if (response.getStatusLine().getStatusCode() == 200) {
                BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                String line;
                while ((line = rd.readLine()) != null) {
                    result.append(line);
                }

            } else {
                throw new Exception("Error Occurred while initializing transaction");
            }

            ObjectMapper mapper = new ObjectMapper();

            initializeTransactionResponse = mapper.readValue(result.toString(), InitializeTransactionResponse.class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return initializeTransactionResponse;
    }
}
