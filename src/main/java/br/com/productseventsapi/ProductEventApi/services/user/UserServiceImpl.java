package br.com.productseventsapi.ProductEventApi.services.user;

import br.com.productseventsapi.ProductEventApi.dtos.user.CreateUserDTO;
import br.com.productseventsapi.ProductEventApi.dtos.user.UserDTO;
import br.com.productseventsapi.ProductEventApi.exceptions.UserNotFoundException;
import br.com.productseventsapi.ProductEventApi.mappers.UserMapper;
import br.com.productseventsapi.ProductEventApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;


    @Override
    public List<UserDTO> findAllUsers() {
        var entitiesList = repository.findAll();
        return entitiesList.stream().map(UserMapper::toDTO).toList();
    }

    @Override
    public UserDTO findUserById(String id) {
        var entity = repository.findById(id).orElseThrow(() -> new UserNotFoundException("Usuário não existe"));
        return UserMapper.toDTO(entity);
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
