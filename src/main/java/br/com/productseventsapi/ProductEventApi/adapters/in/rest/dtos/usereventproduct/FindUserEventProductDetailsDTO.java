package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.usereventproduct;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record FindUserEventProductDetailsDTO(
        String username,
        String productName,
        BigDecimal productPrice,
        LocalDateTime eventHour,
        String eventPlace
) {
}
