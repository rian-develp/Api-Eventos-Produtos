package br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "events")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;
    @NonNull
    @Column(name = "event_hour", nullable = false, unique = true)
    private LocalDateTime eventHour;
    @NonNull
    @Column(name = "event_location", nullable = false)
    private String eventLocation;
}
