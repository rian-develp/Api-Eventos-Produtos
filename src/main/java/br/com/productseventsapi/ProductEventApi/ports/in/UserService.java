package br.com.productseventsapi.ProductEventApi.ports.in;

import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.CreateUserDTO;
import br.com.productseventsapi.ProductEventApi.adapters.in.rest.dtos.user.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAllUsers();
    UserDTO createUser(CreateUserDTO dto);
    UserDTO findUserById(String id);
    UserDTO findUserByEmail(String email);
    void deleteUserById(String id);
}
