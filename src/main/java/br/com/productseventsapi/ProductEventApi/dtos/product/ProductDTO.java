package br.com.productseventsapi.ProductEventApi.dtos.product;

import java.math.BigDecimal;

public record ProductDTO(
        Integer id,
        String productName,
        String productDescription,
        BigDecimal productPrice
) {
}
