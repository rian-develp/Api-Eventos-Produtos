package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user;

public record CreateUserDTO(
        String username,
        String userpassword,
        String useremail
) {
}
