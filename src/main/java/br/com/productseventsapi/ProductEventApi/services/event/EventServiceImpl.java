package br.com.productseventsapi.ProductEventApi.services.event;

import br.com.productseventsapi.ProductEventApi.entities.EventEntity;
import br.com.productseventsapi.ProductEventApi.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository repository;

    @Override
    public List<EventEntity> findAllEvents() {
        return repository.findAll();
    }

    @Override
    public EventEntity findEventById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Evento não existe"));
    }

    @Override
    public void deleteEventById(String id) {
        repository.deleteEventById(id);
    }
}
