package br.com.productseventsapi.ProductEventApi.services;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.event.CreateEventDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.event.EventDTO;
import br.com.productseventsapi.ProductEventApi.domain.exceptions.EventNotFoundException;
import br.com.productseventsapi.ProductEventApi.mappers.EventMapper;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories.EventRepository;
import br.com.productseventsapi.ProductEventApi.ports.in.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Override
    public List<EventDTO> findAllEvents() {
        var entityList = repository.findAll();
        return entityList.stream().map(EventMapper::toDTO).toList();
    }

    @Override
    public EventDTO findEventById(String id) {
        var entity = repository.findById(id).orElseThrow(() -> new EventNotFoundException("Event not found"));
        return EventMapper.toDTO(entity);
    }

    @Override
    public EventDTO createEvent(CreateEventDTO dto) {
        var entity = EventMapper.toEntity(dto);
        repository.save(entity);
        return EventMapper.toDTO(entity);
    }

    @Override
    public void deleteEventById(String id) {
        repository.deleteEventById(id);
    }
}
