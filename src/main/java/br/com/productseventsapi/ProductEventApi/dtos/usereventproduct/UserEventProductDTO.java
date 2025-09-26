package br.com.productseventsapi.ProductEventApi.dtos.usereventproduct;

import br.com.productseventsapi.ProductEventApi.entities.EventEntity;
import br.com.productseventsapi.ProductEventApi.entities.ProductEntity;
import br.com.productseventsapi.ProductEventApi.entities.UserEntity;

public record UserEventProductDTO(
        Integer id,
        EventEntity event,
        UserEntity user,
        ProductEntity product
) {
}
