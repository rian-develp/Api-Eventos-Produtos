package br.com.productseventsapi.ProductEventApi.mappers;

import br.com.productseventsapi.ProductEventApi.dtos.event.CreateEventDTO;
import br.com.productseventsapi.ProductEventApi.dtos.event.EventDTO;
import br.com.productseventsapi.ProductEventApi.entities.EventEntity;

public class EventMapper {

    public static EventDTO toDTO(EventEntity entity){
        return new EventDTO(entity.getId(), entity.getEventHour(),
                entity.getEventLocation());
    }

    public static EventEntity toEntity(CreateEventDTO dto){
        return new EventEntity(dto.eventHour(), dto.eventLocation());
    }
}
