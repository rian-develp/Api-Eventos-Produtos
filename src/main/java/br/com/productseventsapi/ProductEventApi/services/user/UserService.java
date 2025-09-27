package br.com.productseventsapi.ProductEventApi.services.user;

import br.com.productseventsapi.ProductEventApi.dtos.user.CreateUserDTO;
import br.com.productseventsapi.ProductEventApi.dtos.user.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO createUser(CreateUserDTO dto);
    UserDTO findUserById(String id);
    UserDTO findUserByEmail(String email);
    void deleteUserById(String id);
}
