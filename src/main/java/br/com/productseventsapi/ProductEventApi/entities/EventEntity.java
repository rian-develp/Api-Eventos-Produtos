package br.com.productseventsapi.ProductEventApi.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name = "event_hour", nullable = false, unique = true)
    private LocalDateTime eventHour;
    @Column(name = "place", nullable = false)
    private String eventPlace;
    @ManyToMany
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToMany
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
