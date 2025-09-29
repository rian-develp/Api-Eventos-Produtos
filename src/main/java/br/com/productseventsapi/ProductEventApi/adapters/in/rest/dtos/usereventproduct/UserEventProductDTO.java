package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.usereventproduct;

import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities.EventEntity;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities.ProductEntity;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities.UserEntity;

public record UserEventProductDTO(
        Integer id,
        EventEntity event,
        UserEntity user,
        ProductEntity product
) {
}
