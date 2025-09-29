package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.auth;

public record LoginRequestDTO(
        String useremail,
        String userpassword
) {
}
