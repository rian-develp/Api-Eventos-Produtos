package br.com.productseventsapi.ProductEventApi.adapters.in.rest.controllers;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.CreateUserDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.UserDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.response.ResponseBodyError;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.response.ResponseBodySuccessfull;
import br.com.productseventsapi.ProductEventApi.ports.in.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Usuários", description = "Operações relacionadas a usuários")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<ResponseBodySuccessfull<List<UserDTO>>> findAllUsers(){
        var userList = service.findAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseBodySuccessfull<>(HttpStatus.OK.value(), HttpStatus.OK.toString(), LocalDateTime.now(), userList)
        );
    }

    @GetMapping("{id}")
    public ResponseEntity<?> findUserById(@PathVariable("id")  String id){
        try{
            var user = service.findUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseBodyError(HttpStatus.NOT_FOUND.value(), "NOT_FOUND",
                            LocalDateTime.now(), e.getMessage()));
        }
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseBodySuccessfull<UserDTO>> createUser(@RequestBody CreateUserDTO dto){
        var userDto = service.createUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseBodySuccessfull<>(
                        HttpStatus.CREATED.value(),
                        HttpStatus.CREATED.toString(),
                        LocalDateTime.now(),
                        userDto
                )
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable("id") String id){
        service.deleteUserById(id);
        return ResponseEntity.ok("Usuário deletado");
    }
}
