package br.com.productseventsapi.ProductEventApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "product_name", length = 32, nullable = false)
    private String productName;
    @Column(name = "product_description", nullable = false)
    private String productDescription;
    @Column(name = "product_price", nullable = false)
    private Double productPrice;
}
