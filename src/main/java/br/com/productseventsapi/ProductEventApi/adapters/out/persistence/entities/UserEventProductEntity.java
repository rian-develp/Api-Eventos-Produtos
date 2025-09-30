package br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_event_products")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserEventProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity event;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity product;
}
