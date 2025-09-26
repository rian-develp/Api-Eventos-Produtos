package br.com.productseventsapi.ProductEventApi.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private String id;
    @NonNull
    @Column(name = "username", length = 40, nullable = false)
    private String username;
    @NonNull
    @Column(name = "userpassword", length = 20, nullable = false)
    private String userpassword;

}
