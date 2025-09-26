package br.com.productseventsapi.ProductEventApi.services.product;

import br.com.productseventsapi.ProductEventApi.dtos.product.CreateProductDTO;
import br.com.productseventsapi.ProductEventApi.dtos.product.ProductDTO;
import br.com.productseventsapi.ProductEventApi.exceptions.ProductNotFoundException;
import br.com.productseventsapi.ProductEventApi.mappers.ProductMapper;
import br.com.productseventsapi.ProductEventApi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

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
        var entity = repository.findById(id).orElseThrow(() -> new ProductNotFoundException("Produto não existe"));
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
