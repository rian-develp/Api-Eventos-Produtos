package br.com.productseventsapi.ProductEventApi.services.event;

import br.com.productseventsapi.ProductEventApi.dtos.event.CreateEventDTO;
import br.com.productseventsapi.ProductEventApi.dtos.event.EventDTO;
import br.com.productseventsapi.ProductEventApi.exceptions.EventNotFoundException;
import br.com.productseventsapi.ProductEventApi.mappers.EventMapper;
import br.com.productseventsapi.ProductEventApi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository repository;

    @Override
    public List<EventDTO> findAllEvents() {
        var entityList = repository.findAll();
        return entityList.stream().map(EventMapper::toDTO).toList();
    }

    @Override
    public EventDTO findEventById(String id) {
        var entity = repository.findById(id).orElseThrow(() -> new EventNotFoundException("Evento não existe"));
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
