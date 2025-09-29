package br.com.productseventsapi.ProductEventApi.ports.in;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.product.CreateProductDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.product.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findAllProducts();
    ProductDTO findProductById(Integer id);
    ProductDTO createProduct(CreateProductDTO dto);
    void deleteProductById(Integer id);
}
