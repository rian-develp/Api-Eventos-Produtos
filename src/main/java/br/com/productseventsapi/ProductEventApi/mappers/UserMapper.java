package br.com.productseventsapi.ProductEventApi.mappers;

import br.com.productseventsapi.ProductEventApi.dtos.user.CreateUserDTO;
import br.com.productseventsapi.ProductEventApi.dtos.user.UserDTO;
import br.com.productseventsapi.ProductEventApi.entities.UserEntity;

public class UserMapper {

    public static UserDTO toDTO(UserEntity entity){
        return new UserDTO(entity.getId(), entity.getUsername(), entity.getUseremail(), entity.getUserpassword());
    }

    public static UserEntity toEntity(CreateUserDTO dto){
        return new UserEntity(dto.username(), dto.useremail(), dto.userpassword());
    }
}
