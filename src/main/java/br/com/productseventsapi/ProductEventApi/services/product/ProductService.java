package br.com.productseventsapi.ProductEventApi.services.product;

import br.com.productseventsapi.ProductEventApi.dtos.product.CreateProductDTO;
import br.com.productseventsapi.ProductEventApi.dtos.product.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();
    ProductDTO findProductById(Integer id);
    ProductDTO createProduct(CreateProductDTO dto);
    void deleteProductById(Integer id);
}
