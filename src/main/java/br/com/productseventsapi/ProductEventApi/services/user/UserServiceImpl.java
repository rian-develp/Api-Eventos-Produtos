package br.com.productseventsapi.ProductEventApi.services.user;

import br.com.productseventsapi.ProductEventApi.entities.UserEntity;
import br.com.productseventsapi.ProductEventApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository repository;


    @Override
    public List<UserEntity> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public UserEntity findUserById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não existe"));
    }

    @Override
    public void deleteUserById(String id) {
        repository.deleteUserById(id);
    }
}
