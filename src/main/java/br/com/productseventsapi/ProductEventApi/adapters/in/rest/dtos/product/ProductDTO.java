package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.product;

import java.math.BigDecimal;

public record ProductDTO(
        Integer id,
        String productName,
        String productDescription,
        BigDecimal productPrice
) {
}
