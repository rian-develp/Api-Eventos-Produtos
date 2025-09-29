package br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

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
    private BigDecimal productPrice;
}
