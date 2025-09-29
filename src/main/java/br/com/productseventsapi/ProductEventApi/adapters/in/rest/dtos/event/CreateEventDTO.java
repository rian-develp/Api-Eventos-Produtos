package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.event;

import java.time.LocalDateTime;

public record CreateEventDTO(
        LocalDateTime eventHour,
        String eventLocation
) {
}
