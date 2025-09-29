package br.com.productseventsapi.ProductEventApi.adapters.in.rest.controllers;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.auth.LoginRequestDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.auth.ResponseDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.CreateUserDTO;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities.UserEntity;
import br.com.productseventsapi.ProductEventApi.domain.exceptions.UserNotFoundException;
import br.com.productseventsapi.ProductEventApi.adapters.out.security.TokenService;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO dto){

        var user = repository.findUserByEmail(dto.useremail());

        if (user == null)
            throw new UserNotFoundException("User not found");

        if (encoder.matches(dto.userpassword(), user.getUserpassword())){
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new ResponseDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody CreateUserDTO dto){

        var user = repository.findUserByEmail(dto.useremail());

        if (user == null){

            UserEntity entity = new UserEntity();
            entity.setUsername(dto.username());
            entity.setUseremail(dto.useremail());
            entity.setUserpassword(encoder.encode(dto.userpassword()));
            repository.save(entity);

            if (encoder.matches(dto.userpassword(), entity.getUserpassword())){
                String token = tokenService.generateToken(entity);
                return ResponseEntity.ok(new ResponseDTO(entity.getUsername(), token));
            }
        }


        return ResponseEntity.badRequest().body(user);
    }
}
