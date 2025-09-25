package br.com.productseventsapi.ProductEventApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_event_products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEventProduct {

    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private EventEntity eventId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;
}
