package br.com.productseventsapi.ProductEventApi.controllers;

import br.com.productseventsapi.ProductEventApi.entities.UserEntity;
import br.com.productseventsapi.ProductEventApi.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public ResponseEntity<List<UserEntity>> findAllUsers(){
        var userList = service.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(userList);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id")  String id){
        try{
            var user = service.findUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/users/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") String id){
        service.deleteUserById(id);
        return ResponseEntity.ok("Usuário deletado");
    }
}
