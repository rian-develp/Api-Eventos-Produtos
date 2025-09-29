package br.com.productseventsapi.ProductEventApi.ports.in;

import br.com.productseventsapi.ProductEventApi.ports.out.projections.UserEventProductProjection;

import java.util.List;

public interface UserEventProductService {

    public List<UserEventProductProjection> findUserEventProductDetails();
    public List<UserEventProductProjection> findUserEventProductDetailsByEventId(String eventId);
}
