package com.getdev.automotivepartsecommerce.payloads.response;

import lombok.*;

@Data
@ToString
@RequiredArgsConstructor
public class HttpResponse {
    private Integer status;
    private String message;
}
