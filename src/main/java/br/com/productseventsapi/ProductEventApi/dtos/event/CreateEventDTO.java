package br.com.productseventsapi.ProductEventApi.dtos.event;

import java.time.LocalDateTime;

public record CreateEventDTO(
        LocalDateTime eventHour,
        String eventLocation
) {
}
