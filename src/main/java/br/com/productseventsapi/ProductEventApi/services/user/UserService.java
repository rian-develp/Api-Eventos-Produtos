package br.com.productseventsapi.ProductEventApi.services.user;

import br.com.productseventsapi.ProductEventApi.entities.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> findAllUsers();
    UserEntity findUserById(String id);
    void deleteUserById(String id);
}
