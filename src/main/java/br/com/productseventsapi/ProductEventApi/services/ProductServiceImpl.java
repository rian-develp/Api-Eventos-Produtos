package br.com.productseventsapi.ProductEventApi.services;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.product.CreateProductDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.product.ProductDTO;
import br.com.productseventsapi.ProductEventApi.domain.exceptions.ProductNotFoundException;
import br.com.productseventsapi.ProductEventApi.mappers.ProductMapper;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories.ProductRepository;
import br.com.productseventsapi.ProductEventApi.ports.in.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductDTO> findAllProducts() {
        var entitiesList = repository.findAll();
        return entitiesList.stream().map(
                entity -> new ProductDTO(
                            entity.getId(),
                            entity.getProductName(),
                            entity.getProductDescription(),
                            entity.getProductPrice()
                        )).toList();
    }

    @Override
    public ProductDTO findProductById(Integer id) {
        var entity = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return ProductMapper.toDTO(entity);
    }

    @Override
    public ProductDTO createProduct(CreateProductDTO dto) {
        var entity = repository.save(ProductMapper.toEntity(dto));
        return ProductMapper.toDTO(entity);
    }

    @Override
    public void deleteProductById(Integer id) {
        repository.deleteProductById(id);
    }
}
