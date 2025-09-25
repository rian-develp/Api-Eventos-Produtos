package br.com.productseventsapi.ProductEventApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NonNull
    @Column(name = "product_name", length = 32, nullable = false)
    private String productName;
    @NonNull
    @Column(name = "product_description", nullable = false)
    private String productDescription;
    @NonNull
    @Column(name = "product_price", nullable = false)
    private Double productPrice;
}
