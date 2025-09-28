package br.com.productseventsapi.ProductEventApi.repositories;

import br.com.productseventsapi.ProductEventApi.entities.UserEventProductEntity;
import br.com.productseventsapi.ProductEventApi.projections.UserEventProductProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEventProductRepository extends JpaRepository<UserEventProductEntity, Integer> {

    @Query(value = "SELECT uep.id AS id, " +
            "u.username AS username, " +
            "p.product_name AS productName, " +
            "p.product_price AS productPrice, " +
            "e.event_hour AS eventHour, " +
            "e.event_location AS eventLocation " +
            "FROM user_event_products uep " +
            "JOIN users u ON u.id = uep.user_id " +
            "JOIN products p ON p.id = uep.product_id " +
            "JOIN events e ON e.id = uep.event_id",
    nativeQuery = true)
    List<UserEventProductProjection> findUserEventProductDetails();

    @Query(value = "SELECT uep.id AS id, " +
            "u.username AS username, " +
            "p.product_name AS productName, " +
            "p.product_price AS productPrice, " +
            "e.event_hour AS eventHour, " +
            "e.event_location AS eventLocation " +
            "FROM user_event_products uep " +
            "JOIN events e ON e.id = uep.event_id " +
            "JOIN users u ON u.id = uep.user_id " +
            "JOIN products p ON p.id = uep.product_id " +
            "WHERE e.id = :id",
            nativeQuery = true)
    List<UserEventProductProjection> findUserEventProductDetailsByEventId(@Param("id") String id);
}
