package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user;

public record UserDTO (
        String id,
        String username,
        String useremail,
        String userpassword
){
}
