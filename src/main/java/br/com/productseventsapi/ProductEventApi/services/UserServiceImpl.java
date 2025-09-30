package br.com.productseventsapi.ProductEventApi.services;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.CreateUserDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.UserDTO;
import br.com.productseventsapi.ProductEventApi.domain.exceptions.UserNotFoundException;
import br.com.productseventsapi.ProductEventApi.mappers.UserMapper;
import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories.UserRepository;
import br.com.productseventsapi.ProductEventApi.ports.in.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;


    @Override
    public List<UserDTO> findAllUsers() {
        var entitiesList = repository.findAll();
        return entitiesList.stream().map(UserMapper::toDTO).toList();
    }

    @Override
    public UserDTO findUserById(String id) {
        var entity = repository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
        return UserMapper.toDTO(entity);
    }

    @Override
    public UserDTO findUserByEmail(String email) {
        var entity = repository.findUserByEmail(email);
        if (entity != null)
            return UserMapper.toDTO(entity);
        else
            throw new UserNotFoundException("User not found");
    }

    @Override
    public UserDTO createUser(CreateUserDTO dto){
        var entity = repository.save(UserMapper.toEntity(dto));
        return UserMapper.toDTO(entity);
    }

    @Override
    public void deleteUserById(String id) {
        repository.deleteUserById(id);
    }
}
