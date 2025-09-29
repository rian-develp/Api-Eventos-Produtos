package br.com.productseventsapi.ProductEventApi.adapters.in.rest.controllers;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.product.CreateProductDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.product.ProductDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.response.ResponseBodySuccessfull;
import br.com.productseventsapi.ProductEventApi.ports.in.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Produtos", description = "Operações relacionadas a produtos")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts(){
        return ResponseEntity.ok(service.findAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findProductById(@PathVariable("id") Integer id){
        try {
            var productDto = service.findProductById(id);
            return ResponseEntity.ok(
                    new ResponseBodySuccessfull<>(
                            HttpStatus.OK.value(),
                            HttpStatus.OK.toString(),
                            LocalDateTime.now(),
                            productDto
                    )
            );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseBodySuccessfull<ProductDTO>> createProduct(@RequestBody CreateProductDTO dto){
        var productDto = service.createProduct(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseBodySuccessfull<>(
                        HttpStatus.CREATED.value(),
                        HttpStatus.CREATED.toString(),
                        LocalDateTime.now(),
                        productDto
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") Integer id){
        service.deleteProductById(id);
        return ResponseEntity.ok("Produto deletado com sucesso");
    }
}