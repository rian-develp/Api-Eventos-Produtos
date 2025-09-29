package br.com.productseventsapi.ProductEventApi.ports.in;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.event.CreateEventDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.event.EventDTO;

import java.util.List;

public interface EventService {

    List<EventDTO> findAllEvents();
    EventDTO findEventById(String id);
    EventDTO createEvent(CreateEventDTO dto);
    void deleteEventById(String id);
}
