package br.com.productseventsapi.ProductEventApi.services.product;

import br.com.productseventsapi.ProductEventApi.entities.ProductEntity;

import java.util.List;

public interface ProductService {

    List<ProductEntity> findAllProducts();
    ProductEntity findProductById(Integer id);
    void deleteProductById(Integer id);
}
