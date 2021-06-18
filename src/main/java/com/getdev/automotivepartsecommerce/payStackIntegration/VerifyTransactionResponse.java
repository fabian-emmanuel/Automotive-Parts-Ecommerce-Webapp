package com.getdev.automotivepartsecommerce.payStackIntegration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.getdev.automotivepartsecommerce.dtos.PayStackData;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VerifyTransactionResponse {

    /**
     * this status is "true" if the request is successful and false if is not
     * NOTE: This does not mean the transaction was successful, data.status holds that information
     */
    private String status;
    /**
     * information about the request, could be "verification successful" or "invalid key"
     */
    private String message;
    /**
     * contains details about the transaction
     */
    private PayStackData payStackData;

}