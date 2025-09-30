package br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories;

import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, String> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `events` WHERE id = :id", nativeQuery = true)
    void deleteEventById(@Param("id") String id);

}
