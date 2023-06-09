package com.example.b2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(max = 50, message = "Name mus be les than 50 characters")
    @NotBlank(message = "Name is required")

    private String name;
    @Size(max = 250, message = "Name mus be les than 250 characters")

    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();


}
