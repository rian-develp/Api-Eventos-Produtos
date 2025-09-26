package br.com.productseventsapi.ProductEventApi.dtos.event;

import java.time.LocalDateTime;

public record EventDTO(
        String id,
        LocalDateTime eventHour,
        String eventPlace
) {
}
