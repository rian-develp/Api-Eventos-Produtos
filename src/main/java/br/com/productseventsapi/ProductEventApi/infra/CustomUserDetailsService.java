package br.com.productseventsapi.ProductEventApi.infra;

import br.com.productseventsapi.ProductEventApi.dtos.user.UserDTO;
import br.com.productseventsapi.ProductEventApi.mappers.UserMapper;
import br.com.productseventsapi.ProductEventApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;

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
