package br.com.productseventsapi.ProductEventApi.services.usereventproduct;

import br.com.productseventsapi.ProductEventApi.projections.UserEventProductProjection;

import java.util.List;

public interface UserEventProductService {

    public List<UserEventProductProjection> findUserEventProductDetails();
    public List<UserEventProductProjection> findUserEventProductDetailsByEventId(String eventId);
}
