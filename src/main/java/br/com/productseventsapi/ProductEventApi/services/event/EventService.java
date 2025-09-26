package br.com.productseventsapi.ProductEventApi.services.event;

import br.com.productseventsapi.ProductEventApi.dtos.event.CreateEventDTO;
import br.com.productseventsapi.ProductEventApi.dtos.event.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> findAllEvents();
    EventDTO findEventById(String id);
    EventDTO createEvent(CreateEventDTO dto);
    void deleteEventById(String id);
}
