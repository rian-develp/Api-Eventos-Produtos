package br.com.productseventsapi.ProductEventApi.dtos.product;

import java.math.BigDecimal;

public record CreateProductDTO(
        String productName,
        String productDescription,
        BigDecimal productPrice
) {
}
