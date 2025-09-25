package br.com.productseventsapi.ProductEventApi.repositories;

import br.com.productseventsapi.ProductEventApi.entities.UserEventProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEventProductRepository extends JpaRepository<UserEventProduct, Integer> {

    @Query(value = "SELECT users.username, " +
            "products.product_name," +
            "products.product_price, " +
            "events.event_hour " +
            "events.event_place " +
            "FROM user_event_products " +
            "JOIN events ON events.id = user_event_products.event_id " +
            "JOIN users ON users.id = user_event_products.user_id " +
            "JOIN products ON products.id = user_event_products.product_id",
    nativeQuery = true)
    List<FindUserEventProductDetailsDTO> findUserEventProductDetails();

    @Query(value = "SELECT users.username, " +
            "products.product_name," +
            "products.product_price, " +
            "events.event_hour " +
            "events.event_place " +
            "FROM user_event_products " +
            "JOIN events ON events.id = user_event_products.event_id " +
            "JOIN users ON users.id = user_event_products.user_id " +
            "JOIN products ON products.id = user_event_products.product_id " +
            "WHERE users.id = :id",
            nativeQuery = true)
    FindUserEventProductDetailsByUserIdDTO findUserEventProductDetails(@Param("id") String id);
}
