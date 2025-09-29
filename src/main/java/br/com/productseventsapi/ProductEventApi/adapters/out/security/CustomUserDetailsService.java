package br.com.productseventsapi.ProductEventApi.adapters.out.security;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.UserDTO;
import br.com.productseventsapi.ProductEventApi.mappers.UserMapper;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDTO dto = UserMapper.toDTO(repository.findUserByEmail(username));

        if (dto == null){
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return new org.springframework.security.core.userdetails.User(dto.useremail(), dto.userpassword(), new ArrayList<>());
    }
}
