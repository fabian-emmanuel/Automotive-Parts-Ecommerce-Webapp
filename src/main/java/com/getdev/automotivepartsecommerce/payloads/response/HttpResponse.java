package com.getdev.automotivepartsecommerce.payloads.response;

import lombok.*;

@Data
@ToString
@RequiredArgsConstructor
public class HttpResponse {
    private int status;
    private String message;
}
