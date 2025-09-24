package br.com.productseventsapi.ProductEventApi.controllers;

import br.com.productseventsapi.ProductEventApi.entities.ProductEntity;
import br.com.productseventsapi.ProductEventApi.services.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> findAllProducts(){
        return ResponseEntity.ok(service.findAllProducts());
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Integer id){
        try {
            return ResponseEntity.ok(service.findProductById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/products/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Integer id){
        return ResponseEntity.ok("Produto deletado com sucesso");
    }
}
