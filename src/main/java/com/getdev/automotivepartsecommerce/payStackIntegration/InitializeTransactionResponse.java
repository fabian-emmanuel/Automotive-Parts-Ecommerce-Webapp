package com.getdev.automotivepartsecommerce.payStackIntegration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@Data
@RequiredArgsConstructor
@JsonInclude(NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InitializeTransactionResponse {
    private boolean status;
    private String message;
    private Data data;

    @Getter
    @Setter
    @JsonInclude(NON_NULL)
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Data {
        private String authorization_url;
        private String access_code;
        private String reference;

    }
}