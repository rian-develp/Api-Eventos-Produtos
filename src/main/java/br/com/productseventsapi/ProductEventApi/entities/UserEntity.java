package br.com.productseventsapi.ProductEventApi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String id;
    @Column(name = "username", length = 40, nullable = false)
    private String username;
    @Column(name = "userpassword", length = 20, nullable = false)
    private String userpassword;
}
