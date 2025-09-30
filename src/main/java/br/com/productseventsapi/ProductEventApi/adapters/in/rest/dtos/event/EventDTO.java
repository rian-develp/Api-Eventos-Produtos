package br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.event;

import java.time.LocalDateTime;

public record EventDTO(
        String id,
        LocalDateTime eventHour,
        String eventLocation
) {
}
