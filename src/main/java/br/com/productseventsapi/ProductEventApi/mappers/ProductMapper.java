package br.com.productseventsapi.ProductEventApi.mappers;

import br.com.productseventsapi.ProductEventApi.dtos.product.CreateProductDTO;
import br.com.productseventsapi.ProductEventApi.dtos.product.ProductDTO;
import br.com.productseventsapi.ProductEventApi.entities.ProductEntity;

public class ProductMapper {

    public static ProductDTO toDTO(ProductEntity entity){
        return new ProductDTO(entity.getId(), entity.getProductName(),
                entity.getProductDescription(), entity.getProductPrice());
    }

    public static ProductEntity toEntity(CreateProductDTO dto){
        return new ProductEntity(dto.productName(), dto.productDescription(), dto.productPrice());
    }
}
