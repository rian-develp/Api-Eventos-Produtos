package br.com.productseventsapi.ProductEventApi.adapters.in.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class ResponseBodySuccessfull<T> {

    private int code;
    private String status;
    private LocalDateTime timestamp;
    private T data;
}
