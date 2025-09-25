package br.com.productseventsapi.ProductEventApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_event_products")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserEventProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity eventId;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;
    @NonNull
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;
}
