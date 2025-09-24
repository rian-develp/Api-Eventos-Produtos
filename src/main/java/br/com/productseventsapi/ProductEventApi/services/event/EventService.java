package br.com.productseventsapi.ProductEventApi.services.event;

import br.com.productseventsapi.ProductEventApi.entities.EventEntity;

import java.util.List;

public interface EventService {

    List<EventEntity> findAllEvents();
    EventEntity findEventById(String id);
    void deleteEventById(String id);
}
