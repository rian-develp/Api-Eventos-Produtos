package br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories;

import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM products WHERE id = :id", nativeQuery = true)
    void deleteProductById(@Param("id") Integer id);
}
