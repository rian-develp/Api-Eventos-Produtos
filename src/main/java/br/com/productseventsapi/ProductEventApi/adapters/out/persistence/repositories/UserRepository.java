package br.com.productseventsapi.ProductEventApi.adapters.out.persistence.repositories;

import br.com.productseventsapi.ProductEventApi.adapters.out.persistence.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM users WHERE id = :id", nativeQuery = true)
    void deleteUserById(@Param("id") String id);

    @Query(value = "SELECT * FROM users WHERE useremail = :email", nativeQuery = true)
    UserEntity findUserByEmail(@Param("email") String email);

}
