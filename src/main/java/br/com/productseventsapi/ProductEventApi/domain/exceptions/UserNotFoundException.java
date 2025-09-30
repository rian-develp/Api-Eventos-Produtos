package br.com.productseventsapi.ProductEventApi.domain.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message){
        super(message);
    }
}
