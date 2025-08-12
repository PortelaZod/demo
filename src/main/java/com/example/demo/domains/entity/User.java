package com.example.demo.domains.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Setter
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;

    private String name;

    private String lastName;

    @Column(unique = true)
    private String email;
}
