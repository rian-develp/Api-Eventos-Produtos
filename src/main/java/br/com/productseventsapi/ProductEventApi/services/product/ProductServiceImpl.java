package br.com.productseventsapi.ProductEventApi.services.product;

import br.com.productseventsapi.ProductEventApi.entities.ProductEntity;
import br.com.productseventsapi.ProductEventApi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository repository;

    @Override
    public List<ProductEntity> findAllProducts() {
        return repository.findAll();
    }

    @Override
    public ProductEntity findProductById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não existe"));
    }

    @Override
    public void deleteProductById(Integer id) {
        repository.deleteProductById(id);
    }
}
