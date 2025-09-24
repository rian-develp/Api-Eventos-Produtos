package br.com.productseventsapi.ProductEventApi.controllers;

import br.com.productseventsapi.ProductEventApi.entities.EventEntity;
import br.com.productseventsapi.ProductEventApi.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping("/events")
    public ResponseEntity<List<EventEntity>> findAllEvents(){
        return ResponseEntity.ok(service.findAllEvents());
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<?> findEventById(@PathVariable String id){
        try{
            return ResponseEntity.ok(service.findEventById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/events/delete/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable String id){
        return ResponseEntity.ok("Evento deletado com sucesso");
    }
}
