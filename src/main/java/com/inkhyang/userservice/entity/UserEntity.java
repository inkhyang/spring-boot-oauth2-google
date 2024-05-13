package com.inkhyang.userservice.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    private String email;
    private Set<Role> roles;

    public UserEntity(String name, String email, Set<Role> roles) {
        this.name = name;
        this.email = email;
        this.roles = roles;
    }
}
