package br.com.productseventsapi.ProductEventApi.domain.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {super(message);}
}
