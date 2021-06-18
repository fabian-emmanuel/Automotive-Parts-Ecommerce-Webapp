package com.getdev.automotivepartsecommerce.payStackIntegration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.getdev.automotivepartsecommerce.dtos.PayStackBearer.Account;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Digits;
import java.util.List;

import static com.getdev.automotivepartsecommerce.dtos.PayStackBearer.account;

@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitializeTransactionRequest {

    /**
     Amount in kobo
     */
    @Digits(integer = 9, fraction = 0)
    private Integer amount;

    private String email;

    private String plan;

    private String reference;

    private String subAccount;

    private Account bearer = account;

    private String callBackUrl;

    private Float quantity;

    private Integer invoiceLimit;

    private Integer transactionCharge;

    private List<String> channel;
}
