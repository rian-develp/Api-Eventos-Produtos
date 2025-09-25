package br.com.productseventsapi.ProductEventApi.dtos;

import java.time.LocalDateTime;

public record FindUserEventProductDetailsDTO(
        String username,
        String productName,
        Double productPrice,
        LocalDateTime eventHour,
        String eventPlace
) {
}
