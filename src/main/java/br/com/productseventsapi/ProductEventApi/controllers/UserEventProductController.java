package br.com.productseventsapi.ProductEventApi.controllers;

import br.com.productseventsapi.ProductEventApi.projections.UserEventProductProjection;
import br.com.productseventsapi.ProductEventApi.response.ResponseBodySuccessfull;
import br.com.productseventsapi.ProductEventApi.services.usereventproduct.UserEventProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/usereventproducts")
@Tag(name = "Tabela intermedária entre usuários, produtos e eventos", description = "Operações relacionadas a detalhes do evento")
public class UserEventProductController {

    @Autowired
    private UserEventProductService service;

    @GetMapping
    public ResponseEntity<ResponseBodySuccessfull<List<UserEventProductProjection>>> findAllUserEventProductDetails(){
        var detailsDtoList = service.findUserEventProductDetails();
        return ResponseEntity.ok(new ResponseBodySuccessfull<>(
                HttpStatus.OK.value(),
                HttpStatus.OK.toString(),
                LocalDateTime.now(),
                detailsDtoList
        ));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<ResponseBodySuccessfull<List<UserEventProductProjection>>> findUserEventProductDetailsByEventId(@PathVariable("eventId") String eventId){
        var detailsDtoList = service.findUserEventProductDetailsByEventId(eventId);
        return ResponseEntity.ok(
                new ResponseBodySuccessfull<>(
                        HttpStatus.OK.value(),
                        HttpStatus.OK.toString(),
                        LocalDateTime.now(),
                        detailsDtoList
                )
        );
    }
}
