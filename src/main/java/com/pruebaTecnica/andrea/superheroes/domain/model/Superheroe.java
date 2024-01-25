package com.pruebaTecnica.andrea.superheroes.domain.model;


import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "superheroes")
public record Superheroe(
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column
        UUID id,
        @Column
        String name,
        @Column
        String alias,
        @Column
        String power,
        @Column
        String universe
) {

}