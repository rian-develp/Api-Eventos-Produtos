package br.com.productseventsapi.ProductEventApi.services.usereventproduct;

import br.com.productseventsapi.ProductEventApi.projections.UserEventProductProjection;
import br.com.productseventsapi.ProductEventApi.repositories.UserEventProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserEventProductServiceImpl implements UserEventProductService {

    @Autowired
    private UserEventProductRepository repository;


    @Override
    public List<UserEventProductProjection> findUserEventProductDetails() {
        return repository.findUserEventProductDetails();
    }

    @Override
    public List<UserEventProductProjection> findUserEventProductDetailsByEventId(String eventId) {
        return repository.findUserEventProductDetailsByEventId(eventId);
    }
}
