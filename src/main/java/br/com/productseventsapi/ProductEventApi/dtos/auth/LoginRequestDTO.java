package br.com.productseventsapi.ProductEventApi.dtos.auth;

public record LoginRequestDTO(
        String useremail,
        String userpassword
) {
}
