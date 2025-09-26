package br.com.productseventsapi.ProductEventApi.mappers;

import br.com.productseventsapi.ProductEventApi.dtos.usereventproduct.FindUserEventProductDetailsDTO;
import br.com.productseventsapi.ProductEventApi.dtos.usereventproduct.UserEventProductDTO;
import br.com.productseventsapi.ProductEventApi.entities.UserEventProductEntity;

public class UserEventProductMapper {

    public static UserEventProductDTO toDTO(UserEventProductEntity entity){
        return new UserEventProductDTO(entity.getId(), entity.getEvent(), entity.getUser(), entity.getProduct());
    }

    public static UserEventProductEntity toEntity(UserEventProductDTO dto){
        return new UserEventProductEntity(dto.event(), dto.user(), dto.product());
    }

    public static FindUserEventProductDetailsDTO toFindUserEventProductDetailsDTO(UserEventProductEntity entity){
        return new FindUserEventProductDetailsDTO(entity.getUser().getUsername(),
                entity.getProduct().getProductName(),
                entity.getProduct().getProductPrice(),
                entity.getEvent().getEventHour(),
                entity.getEvent().getEventPlace()
        );
    }
}
