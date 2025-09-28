package br.com.productseventsapi.ProductEventApi.controllers;

import br.com.productseventsapi.ProductEventApi.dtos.event.EventDTO;
import br.com.productseventsapi.ProductEventApi.exceptions.EventNotFoundException;
import br.com.productseventsapi.ProductEventApi.response.ResponseBodyError;
import br.com.productseventsapi.ProductEventApi.response.ResponseBodySuccessfull;
import br.com.productseventsapi.ProductEventApi.services.event.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<ResponseBodySuccessfull<List<EventDTO>>> findAllEvents(){
        var entitiesList = service.findAllEvents();
        return ResponseEntity.ok(
                new ResponseBodySuccessfull<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.toString(),
                        LocalDateTime.now(),
                        entitiesList
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findEventById(@PathVariable String id){
        try{
            var result = service.findEventById(id);
            return ResponseEntity.ok(
                    new ResponseBodySuccessfull<>(
                            HttpStatus.OK.value(),
                            HttpStatus.OK.toString(),
                            LocalDateTime.now(),
                            result
                    )
            );
        } catch (EventNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseBodyError(
                            HttpStatus.NOT_FOUND.value(),
                            HttpStatus.NOT_FOUND.toString(),
                            LocalDateTime.now(),
                            e.getMessage()
                    )
            );
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEventById(@PathVariable String id){
        return ResponseEntity.ok("Event deleted successfully");
    }
}
